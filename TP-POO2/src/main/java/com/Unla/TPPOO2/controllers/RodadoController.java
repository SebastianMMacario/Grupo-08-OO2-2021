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
import com.Unla.TPPOO2.interfaceService.IRodadoService;
import com.Unla.TPPOO2.models.Rodado;

@RequestMapping("/rodado")
@Controller
public class RodadoController {

	@Autowired
	private IRodadoService rodadoService;
	
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("rodado",new Rodado());
		return ViewRouteHelper.RODADO_AGREGAR;
	}
	
	
	@PostMapping("/save")
	public String guardar(@Validated @ModelAttribute("rodado") Rodado r, Model model) {
		try {
		
			rodadoService.save(r);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("errorMsg",e.getMessage());
			return ViewRouteHelper.RODADO_AGREGAR;
		}
		return ViewRouteHelper.INDEX_HOME;
	}
	
	
	@GetMapping("/cancelActionRodado")
	public String cancelarAccion() {
		return ViewRouteHelper.INDEX_HOME;
	}
	
}
