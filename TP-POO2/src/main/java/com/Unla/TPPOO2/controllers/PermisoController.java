package com.Unla.TPPOO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.Unla.TPPOO2.interfaceService.IPermisoDiarioService;
import com.Unla.TPPOO2.interfaceService.IPermisoPeriodoService;
import com.Unla.TPPOO2.interfaceService.IPermisoService;
import com.Unla.TPPOO2.interfaceService.IPersonaService;
import com.Unla.TPPOO2.interfaceService.IRodadoService;
import com.Unla.TPPOO2.interfaceService.IUserLogueadoService;
import com.Unla.TPPOO2.models.Lugar;
import com.Unla.TPPOO2.models.Permiso;
import com.Unla.TPPOO2.models.PermisoDiario;
import com.Unla.TPPOO2.models.PermisoPeriodo;
import com.Unla.TPPOO2.models.Persona;
import com.Unla.TPPOO2.models.Rodado;

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
	
	@Autowired
	private IPermisoDiarioService permisoDiarioService;
	
	@Autowired
	private IPermisoPeriodoService permisoPeriodoService;
	
	@Autowired
	private IUserLogueadoService userLoguadoService;
		

	@PreAuthorize("hasRole('ROLE_AUDIT') or (!hasRole('ROLE_AUDIT') and !hasRole('ROLE_ADMIN'))")	
	@GetMapping("/listPermiso")
	public String listar(Model model) {
		model.addAttribute("personas", personaService.listar());
		model.addAttribute("rodados", rodadoService.listar());
		model.addAttribute("permisos", permisoService.listar());
		model.addAttribute("permisosDiarios", permisoDiarioService.listarPermisosDiarios());
		model.addAttribute("permisosPeriodo", permisoPeriodoService.listarPermisosPeriodo());
		model.addAttribute("lugares", lugarService.listar());
		model.addAttribute("usuarioLogueado", userLoguadoService.traerUserLogueado() );
		return "permiso/traerPermiso";
	}

	@PreAuthorize("hasRole('ROLE_AUDIT') or (!hasRole('ROLE_AUDIT') and !hasRole('ROLE_ADMIN'))")	
	@GetMapping("/listPermisoFiltradoPorPersona")
	public String filtrarPermisosPorPersona(Model model, 
			@RequestParam(value = "persona") int idPersona) {

		System.out.println("personaElegida con id --> " + idPersona);
		
		model.addAttribute("personas", personaService.listar());
		model.addAttribute("rodados", rodadoService.listar());
		model.addAttribute("lugares", lugarService.listar());
		model.addAttribute("usuarioLogueado", userLoguadoService.traerUserLogueado() );
		
		model.addAttribute("permisosDiarios", permisoDiarioService.traerPermisosDiariosPorPersona(idPersona));
		model.addAttribute("permisosPeriodo", permisoPeriodoService.traerPermisosPeriodoPorPersona(idPersona));
//		model.addAttribute("permisos", permisoService.traerPermisosPorPersona(idPersona));
		return "permiso/traerPermiso";
	}
	
	
	@PreAuthorize("hasRole('ROLE_AUDIT')")	
	@GetMapping("/listPermisoFiltradoPorRodado")
	public String filtrarPermisosPorRodado(Model model, 
			@RequestParam(value = "rodado") int idRodado) {

		System.out.println("rodadoElegido con id --> " + idRodado);
		
		model.addAttribute("personas", personaService.listar());
		model.addAttribute("rodados", rodadoService.listar());
		model.addAttribute("lugares", lugarService.listar());
		model.addAttribute("usuarioLogueado", userLoguadoService.traerUserLogueado() );
		
		model.addAttribute("permisosPeriodo", permisoPeriodoService.traerPermisosPeriodoPorRodado(idRodado));
//		model.addAttribute("permisos", permisoService.traerPermisosPorRodado(idRodado));
		return "permiso/traerPermiso";
	}
	
	
	@PreAuthorize("hasRole('ROLE_AUDIT')")	
	@GetMapping("/listPermisoFiltrado")
	public String filtrarPermisosPorFecha(Model model, 
			@RequestParam(value = "fechaDesde") String fechaDesde,
			@RequestParam(value = "fechaHasta") String fechaHasta,
			@RequestParam(value = "desdeHasta", required = false) String desdeHasta) {

		model.addAttribute("personas", personaService.listar());
		model.addAttribute("rodados", rodadoService.listar());
		model.addAttribute("lugares", lugarService.listar());
		model.addAttribute("usuarioLogueado", userLoguadoService.traerUserLogueado());
				
		if(desdeHasta.isBlank()) {
			model.addAttribute("permisosDiarios", permisoDiarioService.traerPermisosDiariosPorFecha(fechaDesde, fechaHasta));
			model.addAttribute("permisosPeriodo", permisoPeriodoService.traerPermisosPeriodoPorFecha(fechaDesde, fechaHasta));
		} else {
			model.addAttribute("permisosDiarios", permisoDiarioService.traerPermisosDiariosPorFechaYLugar(fechaDesde, fechaHasta, desdeHasta));
			model.addAttribute("permisosPeriodo", permisoPeriodoService.traerPermisosPeriodoPorFechaYLugar(fechaDesde, fechaHasta, desdeHasta));		
		}
		
		System.out.println("fechaDesde " + fechaDesde);
		System.out.println("fechaHasta " + fechaHasta);
//		model.addAttribute("permisos", permisoRepository.findByDates(fechaDesde, fechaHasta));
//		model.addAttribute("permisos", permisoService.traerPermisos(fechaDesde, fechaHasta, desdeHasta));
		return "permiso/traerPermiso";
	}

	@GetMapping("/newPermisoDiario")
	public String agregarPermisoDiario(Model model){
		model.addAttribute("permiso", new PermisoDiario());
		model.addAttribute("lugares", lugarService.buscarTodosLugaresDeListAux());
		model.addAttribute("nuevoLugar", new Lugar());

		return "permiso/agregarPermisoDiario";
	}

	@GetMapping("/newPermisoPeriodo")
	public String agregarPermisoPeriodo(Model model) {
		model.addAttribute("permiso", new PermisoPeriodo());
		model.addAttribute("lugares", lugarService.buscarTodosLugaresDeListAux());
		model.addAttribute("nuevoLugar", new Lugar());
		
		return "permiso/agregarPermisoPeriodo";
	}

	@PostMapping("/savePermiso")
	public String guardarPermiso(@Validated @ModelAttribute("permiso") Permiso p, Model model,
			@RequestParam(value = "dni")long dniPersona,
			@RequestParam(value = "dominio", required = false)String dominioVehiculo) {
		
		p.setDesdeHasta(lugarService.buscarTodosLugaresDeListAux());
		
		try {
			Persona persona = personaService.listarDNI(dniPersona);
			p.setPersona(persona);
			
			if(p instanceof PermisoPeriodo) {
				Rodado rodado = rodadoService.listarDominio(dominioVehiculo);
				((PermisoPeriodo) p).setRodado(rodado);
			}	
			permisoService.save(p);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			
			model.addAttribute("permiso", p);
			model.addAttribute("lugares", lugarService.buscarTodosLugaresDeListAux());
			model.addAttribute("nuevoLugar", new Lugar());
			model.addAttribute("errorMsg", e.getMessage());

			if(p instanceof PermisoDiario) return "permiso/agregarPermisoDiario";
			else return "permiso/agregarPermisoPeriodo";
		}
		
		lugarService.borrarTodosLugaresDeListAux(); // reinicio el listado limpiandolo
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

		model.addAttribute("permiso", p);
		model.addAttribute("nuevoLugar", new Lugar());
		model.addAttribute("lugares", lugarService.buscarTodosLugaresDeListAux());

		if(p instanceof PermisoDiario) return "permiso/agregarPermisoDiario";
		else return "permiso/agregarPermisoPeriodo";
	}

	
	@PostMapping("/buscarLugar")
	public String buscarLugar(@Validated @ModelAttribute("lugarBuscado") Lugar lugar, 
			@Validated @ModelAttribute("permiso") Permiso p , Model model) {

		try {
			Lugar lugarBuscado = lugarService.buscarLugarPorNombre(lugar.getLugar());
			lugarService.guardarLugarEncontradoEnListAux(lugarBuscado);
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
		}

		model.addAttribute("permiso", p);
		model.addAttribute("nuevoLugar", new Lugar());
		model.addAttribute("lugares", lugarService.buscarTodosLugaresDeListAux());
		
		if(p instanceof PermisoDiario) return "permiso/agregarPermisoDiario";
		else return "permiso/agregarPermisoPeriodo";
	}

	
	@GetMapping("/cancelActionPermiso")
	public String cancelarAccion() {
		
		lugarService.borrarTodosLugaresDeListAux();
		return "redirect:/listPermiso";
	}

}
