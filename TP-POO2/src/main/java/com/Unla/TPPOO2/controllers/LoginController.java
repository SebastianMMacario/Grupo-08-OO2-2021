package com.Unla.TPPOO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Unla.TPPOO2.interfaceService.IPerfilService;
import com.Unla.TPPOO2.interfaceService.IUserLogueadoService;
import com.Unla.TPPOO2.interfaceService.IusuarioService;

import com.Unla.TPPOO2.helpers.ViewRouteHelper;
import com.Unla.TPPOO2.models.Usuario;


@Controller
public class LoginController {
	
	
	@GetMapping("/login")
	public String login(Model model,
						@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		
		return ViewRouteHelper.ACCESO_LOGIN;
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		SecurityContextHolder.clearContext();
		//return ViewRouteHelper.USER_LOGOUT;
		return ViewRouteHelper.ACCESO_LOGIN;
		
	}
	
	@GetMapping("/loginsuccess")
	public String loginCheckGet() {
		
		return "redirect:/list";
	}
	
	/*
	@GetMapping("/register")
	public String agregar(Model model) {
		model.addAttribute("usuario",new Usuario());
		model.addAttribute("perfiles", perfilService.listar());

		return "register";
	}
	*/
	
	
//	@PostMapping("/loginsuccess")
//	public ModelAndView loginCheckPost() {
//		ModelAndView mAV = new ModelAndView("usuario/listaUsuarios");
//		return mAV;
		//return loginCheckBase();
//	}
	
//	@PostMapping("/save")
//	public String guardar(@Validated Usuario u, Model model) {
//		service.save(u);
//		return "redirect:/list";
//	}
	
//	public ModelAndView loginCheckBase() {
//		ModelAndView mAV = new ModelAndView("usuario/listaUsuarios");
//		
//		//compruebo si se logueo el admin y en tal caso muestro el menu correspondiente, el resto de la pagina permanece igual
//		String roleString = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
//
//		
//		
//		return mAV;
//	}
}
