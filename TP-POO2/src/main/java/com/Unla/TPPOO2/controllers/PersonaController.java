package com.Unla.TPPOO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Unla.TPPOO2.helpers.ViewRouteHelper;
import com.Unla.TPPOO2.interfaceService.IPersonaService;
import com.Unla.TPPOO2.models.Persona;

@RequestMapping("/persona")
@Controller
public class PersonaController {
	
	@Autowired
	private IPersonaService personaService;

	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona",new Persona());
		return ViewRouteHelper.PERSONA_AGREGAR;
	}
	
	
	@PostMapping("/save")
	public String guardar(@Validated @ModelAttribute("persona") Persona p, Model model) {
		
		try {
			personaService.save(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("errorMsg",e.getMessage());
			return ViewRouteHelper.PERSONA_AGREGAR;
		}
		return ViewRouteHelper.INDEX_HOME;
	}
	
	
	@GetMapping("/cancelActionPersona")
	public String cancelarAccion() {
		return ViewRouteHelper.INDEX_HOME;
	}

}
