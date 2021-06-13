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
import com.Unla.TPPOO2.interfaceService.IUsuarioService;
import com.Unla.TPPOO2.models.Usuario;
import com.Unla.TPPOO2.models.Usuario.TipoDocumento;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@Autowired
	private IPerfilService perfilService;
	
	@Autowired
	private IUserLogueadoService userLogueadoService;
	
	@GetMapping("/list")
	public String listar(Model model) {
		
		System.out.println(userLogueadoService.traerUserLogueado());
		Usuario usuarioLogueado = userLogueadoService.traerUserLogueado();
		
		model.addAttribute("usuarios", service.listar());
		model.addAttribute("usuarioLogueado",usuarioLogueado);
		return ViewRouteHelper.USUARIO_TABLA;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("usuario",new Usuario());
		model.addAttribute("perfiles", perfilService.listar());
		
		model.addAttribute("enum",TipoDocumento.values());
		return ViewRouteHelper.USUARIO_AGREGAR;
	}
	
	@PostMapping("/save")
	public String guardar(@Validated @ModelAttribute("usuario") Usuario u, Model model) {
		u.setEnabled(true);
		
		service.save(u);
		return ViewRouteHelper.INDEX_USUARIOS;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/edit/{idUsuario}")
	public String editar(@PathVariable int idUsuario, Model model) {
		Optional<Usuario>usuario=service.listarId(idUsuario);
		model.addAttribute("usuario", usuario);
		model.addAttribute("perfiles", perfilService.listar());
		model.addAttribute("enum",TipoDocumento.values());
		
		model.addAttribute("editMode", true);
		return ViewRouteHelper.USUARIO_AGREGAR;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete/{idUsuario}")
	public String delete(Model model, @PathVariable int idUsuario) {
		service.delete(idUsuario);
		return ViewRouteHelper.INDEX_USUARIOS;
	}
	
	@GetMapping("/cancelAction")
	public String cancelarAccion() {
		return ViewRouteHelper.INDEX_USUARIOS;
	}
	
	
	/**********Reporte de usuaruios en PDF***********/
	@PreAuthorize("hasRole('ROLE_AUDIT')")
	@GetMapping("/generarPDF")
	public String generarReporte(){
		List<Usuario> usuarios = service.listar();		
		Document document = new Document();
		
		try {
			String ruta = System.getProperty(("user.home"));
			PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/Reporte_Usuarios.pdf"));
			
			
            document.open();
			PdfPTable tabla = new PdfPTable(8);
			tabla.addCell("Id");
			tabla.addCell("Apellido");
			tabla.addCell("Nombre");
			tabla.addCell("Tipo de Documento");
			tabla.addCell("Numero de Documento");
			tabla.addCell("Email");
			tabla.addCell("Tipo de usuario");
			tabla.addCell("Nombre de usuario");

		
			if(!usuarios.isEmpty()) {
				for (Usuario usuario : usuarios) {
					
					tabla.addCell(String.valueOf( usuario.getIdUsuario() ));
					tabla.addCell(String.valueOf( usuario.getApellido() ));
					tabla.addCell(String.valueOf( usuario.getNombre() ));
					tabla.addCell(String.valueOf( usuario.getTipoDocumento() ));
					tabla.addCell(String.valueOf( usuario.getNroDocumento() ));
					tabla.addCell(String.valueOf( usuario.getEmail() ));
					tabla.addCell(String.valueOf( usuario.getPerfil().getTipoPerfil() ));
					tabla.addCell(String.valueOf( usuario.getNombreUsuario() ));
				}
				document.add(tabla);			
			}
			else {
				throw new Exception("La BD no tiene usuarios cargados");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());;
		}
		finally {
			document.close();
		}
		
		return ViewRouteHelper.INDEX_USUARIOS;
	}
	
	
}

