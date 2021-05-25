package com.Unla.TPPOO2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Unla.TPPOO2.helpers.ViewRouteHelper;
import com.Unla.TPPOO2.interfaceService.IusuarioService;
import com.Unla.TPPOO2.models.Usuario;

@Controller
@RequestMapping
public class UsuarioController {
	
	@Autowired
	private IusuarioService service;
	
	@GetMapping("/list")
	public String listar(Model model) {
		List<Usuario>usuarios=service.listar();
		model.addAttribute("usuarios", usuarios);
		return ViewRouteHelper.USER_LIST;
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("usuario",new Usuario());
		return ViewRouteHelper.USER_NEW;
	}
	
	@PostMapping("/save")
	public String guardar(@Validated Usuario u, Model model) {
		service.save(u);
		return "redirect:/list";
	}

	@GetMapping("/edit/{idUsuario}")
	public String editar(@PathVariable int idUsuario, Model model) {
		Optional<Usuario>usuario=service.listarId(idUsuario);
		model.addAttribute("usuario", usuario);
		return ViewRouteHelper.USER_NEW;
	}
	
	@GetMapping("/delete/{idUsuario}")
	public String delete(Model model, @PathVariable int idUsuario) {
		service.delete(idUsuario);
		return "redirect:/list";
	}
}
