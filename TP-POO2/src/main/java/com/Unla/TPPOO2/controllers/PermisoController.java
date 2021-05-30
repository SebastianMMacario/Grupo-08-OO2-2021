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
import com.Unla.TPPOO2.models.Permiso;
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
	
	@GetMapping("/newPermisoDiario")
	public String agregarPermisoDiario(Model model) {
		model.addAttribute("permiso",new PermisoDiario());
		model.addAttribute("lugares", lugarService.buscarTodosLugaresDeListAux());
		model.addAttribute("personas",personaService.listar());
		model.addAttribute("nuevoLugar", new Lugar());
			
		return "permiso/agregarPermisoDiario";
	}
	@GetMapping("/newPermisoPeriodo")
	public String agregarPermisoPeriodo(Model model) {
		model.addAttribute("permiso",new PermisoPeriodo());
		model.addAttribute("lugares", lugarService.buscarTodosLugaresDeListAux());
		model.addAttribute("personas",personaService.listar());
		model.addAttribute("nuevoLugar", new Lugar());
		model.addAttribute("rodados",rodadoService.listar());
			
		return "permiso/agregarPermisoPeriodo";
	}
	
	@PostMapping("/savePermisoDiario")
	public String agregarPermisoDiarioFinal(@Validated @ModelAttribute("permiso")PermisoDiario pd) {
		pd.setDesdeHasta(lugarService.buscarTodosLugaresDeListAux());
		permisoService.save(pd);

		lugarService.borrarTodosLugaresDeListAux(); //reinicio el listado limpiandolo
		return "redirect:/login";
	}
	@PostMapping("/savePermisoPeriodo")
	public String agregarPermisoPeriodoFinal(@Validated @ModelAttribute("permiso")PermisoPeriodo pp) {
		pp.setDesdeHasta(lugarService.buscarTodosLugaresDeListAux());
		permisoService.save(pp);

		lugarService.borrarTodosLugaresDeListAux(); //reinicio el listado limpiandolo
		return "redirect:/login";
	}
	
	
	@PostMapping("/saveLugarDiario")
	public String crearLugar(@Validated @ModelAttribute("nuevoLugar") Lugar lugar, Model model) {
		try {
			lugarService.guardarLugarEnBD(lugar);

		}catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("errorMsg", e.getMessage());
		}
		
		return agregarPermisoDiario(model);
	}
	
	
	@PostMapping("/buscarLugarDiario")
	public String buscarLugarDiario(@Validated @ModelAttribute("lugarBuscado") Lugar lugar , Model model) {
		
		try {
			Lugar lugarBuscado = lugarService.buscarLugarPorNombre(lugar.getLugar());
			lugarService.guardarLugarEncontradoEnListAux(lugarBuscado);
		}
		catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
		}
		
		return agregarPermisoDiario(model);
	}
	
	@PostMapping("/saveLugarPeriodo")
	public String crearLugarPeriodo(@Validated @ModelAttribute("nuevoLugar") Lugar lugar, Model model) {
		try {
			lugarService.guardarLugarEnBD(lugar);

		}catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("errorMsg", e.getMessage());
		}
		
		return agregarPermisoPeriodo(model);
	}
	
	
	@PostMapping("/buscarLugarPeriodo")
	public String buscarLugarPeriodo(@Validated @ModelAttribute("lugarBuscado") Lugar lugar , Model model) {
		
		try {
			Lugar lugarBuscado = lugarService.buscarLugarPorNombre(lugar.getLugar());
			lugarService.guardarLugarEncontradoEnListAux(lugarBuscado);
		}
		catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
		}
		
		return agregarPermisoPeriodo(model);
	}
	
	
	@GetMapping("/cancelActionPermiso")
	public String cancelarAccion() {
		return "redirect:/listPermiso";
	}
	
	
	
	
	
	

	
}
