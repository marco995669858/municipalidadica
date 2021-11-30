package com.project.ica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Principal")
public class HomeController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping("/")
    public String getHomepage() {

			return "Principal";
    }
}
