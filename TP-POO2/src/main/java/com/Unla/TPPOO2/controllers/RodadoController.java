package com.Unla.TPPOO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Unla.TPPOO2.interfaceService.IRodadoService;
import com.Unla.TPPOO2.models.Rodado;

@Controller
public class RodadoController {

	@Autowired
	private IRodadoService rodadoService;
	
	@GetMapping("/listRodado")
	public String listar(Model model) {
		model.addAttribute("rodados", rodadoService.listar());
		return "rodados/rodadoVista";
	}
	
	@GetMapping("/newRodado")
	public String agregar(Model model) {
		model.addAttribute("rodado",new Rodado());
		return "rodados/agregarRodado";
	}
	
	@PostMapping("/saveRodado")
	public String guardar(@Validated @ModelAttribute("rodado") Rodado r, Model model) {
		
		rodadoService.save(r);
		return "redirect:/listRodado";
	}
	
	@GetMapping("/cancelActionRodado")
	public String cancelarAccion() {
		return "redirect:/listRodado";
	}
}
