package com.Unla.TPPOO2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/grupo")
@Controller
public class ControllerDePrueba {
	
	@GetMapping("/8")
	public ModelAndView holaMundo() {
		ModelAndView mAV = new ModelAndView("index.html");
		return mAV;
	}
}
