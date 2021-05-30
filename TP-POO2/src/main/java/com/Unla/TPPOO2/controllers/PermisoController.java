package com.Unla.TPPOO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Unla.TPPOO2.helpers.ViewRouteHelper;
import com.Unla.TPPOO2.interfaceService.ILugarService;
import com.Unla.TPPOO2.interfaceService.IPermisoService;
import com.Unla.TPPOO2.interfaceService.IPersonaService;
import com.Unla.TPPOO2.interfaceService.IRodadoService;
import com.Unla.TPPOO2.models.Lugar;
import com.Unla.TPPOO2.models.PermisoDiario;
import com.Unla.TPPOO2.models.PermisoPeriodo;

@Controller
public class PermisoController {
	@Autowired 
	private IPersonaService personaService;
	
	@Autowired 
	private IRodadoService rodadoService;
	
	@Autowired
	private ILugarService lugarService;
	
	@Autowired
	private IPermisoService permisoService;
	
	
	@GetMapping("/listPermiso")
	public String listar(Model model) {
		model.addAttribute("permisos", permisoService.listar());
		return "permiso/permisoVista";
	}
	
//	
//	@GetMapping("/newPermisoPeriodo")
//	public String agregarP(Model model) {
//		model.addAttribute("permiso",new PermisoPeriodo());
//		model.addAttribute("lugares", lugarService.listar());
//		model.addAttribute("personas",personaService.listar());
//		model.addAttribute("rodados",rodadoService.listar());
//		return "permiso/agregarPermisoPeriodo";
//	}
	
	@GetMapping("/newPermisoDiario")
	public String agregarPermisoDiario(Model model) {
		model.addAttribute("permiso",new PermisoDiario());
		model.addAttribute("lugares", lugarService.buscarTodosLugaresDeListAux());
		model.addAttribute("personas",personaService.listar());
		model.addAttribute("nuevoLugar", new Lugar());
			
		return "permiso/agregarPermisoDiario";
	}
	
	@PostMapping("/savePermisoDiario")
	public String agregarPermisoDiarioFinal(@Validated @ModelAttribute("permiso")PermisoDiario pd) {
		pd.setDesdeHasta(lugarService.buscarTodosLugaresDeListAux());
		permisoService.save(pd);

		lugarService.borrarTodosLugaresDeListAux(); //reinicio el listado limpiandolo
		return "redirect:/login";
	}
	
	
	@PostMapping("/saveLugar")
	public String crearLugar(@Validated @ModelAttribute("nuevoLugar") Lugar lugar,Model model) {
		try {
			lugarService.guardarLugarEnBD(lugar);

		}catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("errorMsg", e.getMessage());
		}
		
		return agregarPermisoDiario(model);
	}
	
	
	@PostMapping("/buscarLugar")
	public String buscarLugar(@Validated @ModelAttribute("lugarBuscado") Lugar lugar , Model model) {
		
		try {
			Lugar lugarBuscado = lugarService.buscarLugarPorNombre(lugar.getLugar());
			lugarService.guardarLugarEncontradoEnListAux(lugarBuscado);
		}
		catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
		}
		return agregarPermisoDiario(model);
	}
	
	
	@GetMapping("/cancelActionPermiso")
	public String cancelarAccion() {
		return "redirect:/listPermiso";
	}
	
	
	
	
	
	
//	@PostMapping("/savePermisoDiario")
//	public String guardarPermisoDiario(@Validated @ModelAttribute("permisoDiario") PermisoDiario pd, Model model) {
//		
//		permisoService.savePermisoDiario(pd);
//		return "redirect:/listPermiso";
//	}
//	@PostMapping("/savePermisoPeriodo")
//	public String guardarPermisoPeriodo(@Validated @ModelAttribute("permisoPeriodo") PermisoPeriodo pp, Model model) {
//		
//		permisoService.savePermisoPeriodo(pp);
//		return "redirect:/listPermiso";
//	}
	
	
//	@GetMapping("/getPermiso/{idPermiso}")
//	public String getPermisoID(@PathVariable("idPermiso") int idPermiso, Model model) {
//
//		Permiso findPermisoId = permisoRepository.findByIdPermiso(idPermiso);
//
//		model.addAttribute("title", "Data Permiso");
//		model.addAttribute("lugares", lugarRepository.findAll());
//		model.addAttribute("permiso", findPermisoId);
//
//		return "/permiso/permiso_lugar";
//	}
//	
//	@GetMapping( "/addLugarPermiso/{idPermiso}/lugar")
//    public String addCourseStudent(@PathVariable("idPermiso")int idPermiso,
//                                   @RequestParam("idLugar") int idLugar){
//
//        Lugar lugar = lugarRepository.findByLugarId(idLugar);
//        Permiso permiso =permisoRepository.findByIdPermiso(idPermiso);
//
//        if (permiso!=null){
//            permiso.getDesdeHasta().add(lugar);
//            permisoRepository.save(permiso);
//            
//        }
//        return ViewRouteHelper.ACCESO_LOGIN;
//    }
	
}
