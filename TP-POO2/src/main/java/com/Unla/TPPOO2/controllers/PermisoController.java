package com.Unla.TPPOO2.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
@SessionAttributes("permiso")
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
		return "permiso/traerPermiso";
	}

	@GetMapping("/listPermisoFiltrado")
	public String filtrarPermisosPorFecha(Model model,
			@RequestParam(value = "fechaDesde") String fechaDesde, @RequestParam(value = "fechaHasta") String fechaHasta) {
		
		System.out.println("fechaDesde " + fechaDesde);
		System.out.println("fechaHasta " + fechaHasta);
//		model.addAttribute("permisos", permisoRepository.findByDates(fechaDesde, fechaHasta));
		model.addAttribute("permisos", permisoService.traerPermisos(fechaDesde, fechaHasta));
	
		return "permiso/traerPermiso";
	}

	@GetMapping("/newPermisoDiario")
	public String agregarPermisoDiario(Model model) {
		model.addAttribute("permiso", new PermisoDiario());
		model.addAttribute("lugares", lugarService.buscarTodosLugaresDeListAux());
		model.addAttribute("personas", personaService.listar());
		model.addAttribute("nuevoLugar", new Lugar());
		model.addAttribute("tipo", true);


		return "permiso/agregarPermisoDiario";
	}

	@GetMapping("/newPermisoPeriodo")
	public String agregarPermisoPeriodo(Model model) {
		model.addAttribute("permiso", new PermisoPeriodo());
		model.addAttribute("lugares", lugarService.buscarTodosLugaresDeListAux());
		model.addAttribute("personas", personaService.listar());
		model.addAttribute("nuevoLugar", new Lugar());
		model.addAttribute("rodados", rodadoService.listar());
		model.addAttribute("tipo", false);

		return "permiso/agregarPermisoPeriodo";
	}

	@PostMapping("/savePermiso")
	public String agregarPermisoDiarioFinal(@Validated @ModelAttribute("permiso") Permiso p, Model model) {
		p.setDesdeHasta(lugarService.buscarTodosLugaresDeListAux());
		try {
			permisoService.save(p);
			lugarService.borrarTodosLugaresDeListAux(); // reinicio el listado limpiandolo
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("errorMsg", e.getMessage());

			if(p instanceof PermisoDiario)return agregarPermisoDiario(model);
			else return agregarPermisoPeriodo(model);
		}
		
		return "redirect:/login";
	}

	
	@PostMapping("/saveLugar")
	public String crearLugar(@Validated @ModelAttribute("nuevoLugar") Lugar lugar ,@Validated @ModelAttribute("permiso") Permiso p
			, Model model) {
		try {
			lugarService.guardarLugarEnBD(lugar);

		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("errorMsg", e.getMessage());
		}

		if(p instanceof PermisoDiario) return agregarPermisoDiario(model);
		else return agregarPermisoPeriodo(model);
	}

	
	@PostMapping("/buscarLugar")
	public String buscarLugarDiario(@Validated @ModelAttribute("lugarBuscado") Lugar lugar, 
			@Validated @ModelAttribute("permiso") Permiso p , Model model) {

		try {
			Lugar lugarBuscado = lugarService.buscarLugarPorNombre(lugar.getLugar());
			lugarService.guardarLugarEncontradoEnListAux(lugarBuscado);
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
		}

		if(p instanceof PermisoDiario) return agregarPermisoDiario(model);
		else return agregarPermisoPeriodo(model);
	}

	
	@GetMapping("/cancelActionPermiso")
	public String cancelarAccion() {
		
		lugarService.borrarTodosLugaresDeListAux();
		return "redirect:/listPermiso";
	}

}
