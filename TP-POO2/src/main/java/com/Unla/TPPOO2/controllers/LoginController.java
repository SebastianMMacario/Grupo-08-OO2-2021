package com.Unla.TPPOO2.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Unla.TPPOO2.helpers.ViewRouteHelper;


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
		return ViewRouteHelper.INDEX_HOME;
		
	}
	
	@GetMapping("/loginsuccess")
	public String loginCheckGet() {

		return ViewRouteHelper.INDEX_USUARIOS;
	}
	
	
}
