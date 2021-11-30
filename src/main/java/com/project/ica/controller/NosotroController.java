package com.project.ica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nosotros")
public class NosotroController {
	
	@RequestMapping(value = "/")
	public String index(Model model){
		
		
		return "Nosotros";
	}
}
