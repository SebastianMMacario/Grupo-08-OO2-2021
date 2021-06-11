package com.Unla.TPPOO2.controllers;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Unla.TPPOO2.helpers.ViewRouteHelper;
import com.Unla.TPPOO2.interfaceService.IPerfilService;
import com.Unla.TPPOO2.interfaceService.IUserLogueadoService;
import com.Unla.TPPOO2.models.Perfil;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@RequestMapping("/perfil")
@Controller
public class PerfilController {
	
	@Autowired
	private IPerfilService perfilService;
	
	@Autowired
	private IUserLogueadoService userLogueadoService;
	
	@GetMapping("/list")
	public String listarPerfiles(Model model) {
		List<Perfil>perfiles=perfilService.listar();
		model.addAttribute("perfiles", perfiles);
		
		model.addAttribute("usuarioLogueado",userLogueadoService.traerUserLogueado());
		model.addAttribute("ROLE_ADMIN", perfilService.buscarPorTipoPerfil("ROLE_ADMIN"));
		model.addAttribute("ROLE_AUDIT", perfilService.buscarPorTipoPerfil("ROLE_AUDIT"));

		return ViewRouteHelper.PERFIL_TABLA;
	}


	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("perfil", new Perfil());

		return ViewRouteHelper.PERFIL_AGREGAR;
	}

	@PostMapping("/save")
	public String guardar(@Validated @ModelAttribute("perfil") Perfil p , Model model) {
		perfilService.save(p);
		return ViewRouteHelper.INDEX_PERFILES;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/edit/{idPerfil}")
	public String editar(@PathVariable int idPerfil, Model model) {
		Optional<Perfil> perfil = perfilService.listarId(idPerfil);
		model.addAttribute("perfil", perfil);
		model.addAttribute("perfiles", perfilService.listar());
		model.addAttribute("editMode", true);
		
		return ViewRouteHelper.PERFIL_AGREGAR;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete/{idPerfil}")
	public String delete(Model model, @PathVariable int idPerfil) throws Exception {
		perfilService.delete(idPerfil);
		return ViewRouteHelper.INDEX_PERFILES;
	}

	@GetMapping("/cancelActionPerfil")
	public String cancelarAccion() {
		return ViewRouteHelper.INDEX_PERFILES;
	}


/**********Reporte de perfiles en PDF***********/
	@PreAuthorize("hasRole('ROLE_AUDIT')")
	@GetMapping("/generarPerfilesPDF")
	public String generarReportePDF(){
		List<Perfil> perfiles = perfilService.listar();		
		Document document = new Document();
		
		try {
			String ruta = System.getProperty(("user.home"));
			PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/Reporte_Perfiles.pdf"));
			
	        document.open();
			PdfPTable tabla = new PdfPTable(2);
			tabla.addCell("Id");
			tabla.addCell("Tipo de Perfil");
		
			if(!perfiles.isEmpty()) {
				for (Perfil perfil : perfiles) {
					
					tabla.addCell(String.valueOf( perfil.getIdPerfil() ));
					tabla.addCell(String.valueOf( perfil.getTipoPerfil() ));
				}
				document.add(tabla);			
			}
			else {
				throw new Exception("La BD no tiene perfiles cargados");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());;
		}
		finally {
			document.close();
		}
		
		return ViewRouteHelper.INDEX_PERFILES;
	}


}