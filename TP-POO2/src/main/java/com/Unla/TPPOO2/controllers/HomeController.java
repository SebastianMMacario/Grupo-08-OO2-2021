package com.Unla.TPPOO2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Unla.TPPOO2.helpers.ViewRouteHelper;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String inicio() {
		return ViewRouteHelper.ACCESO_LOGIN;
	}

}
