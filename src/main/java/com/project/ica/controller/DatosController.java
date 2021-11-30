package com.project.ica.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ica.entity.Genero;
import com.project.ica.entity.Rol;
import com.project.ica.entity.Usuario;
import com.project.ica.service.UsuarioService;

@Controller
@RequestMapping("/datos")
public class DatosController {
	
	@Autowired
	private UsuarioService loginService;
	
	@RequestMapping(value = "/")
	public String index(Model model){
		model.addAttribute("genero", loginService.listaGenro());
		return "DatosUsuario";
	}
	
	@RequestMapping(value = "/actualizar")
	public String actualizarUsuario(@RequestParam("codigo") int cod,@RequestParam("nombre") String nom,
			@RequestParam("apePaterno") String paterno,@RequestParam("apeMaterno") String materno, 
			@RequestParam("dni") String dni,@RequestParam("correo") String email,
			@RequestParam("password") String pass,@RequestParam("telefono") String tel,
			 @RequestParam("fecha") String fecha,@RequestParam("genero") int codgenero,
			 @RequestParam("rol") int rol, RedirectAttributes redirect) {

		try {

			Usuario bean = new Usuario();
			
			bean.setCodUsuario(cod);
			bean.setNomUser(nom);
			bean.setApePaterno(paterno);
			bean.setApeMaterno(materno);
			bean.setDniUser(dni);
			bean.setCorreo(email);
			bean.setPassword(pass);
			bean.setCelular(tel);
			bean.setFechNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
			bean.setTbGenero(new Genero(codgenero));
			bean.setRol(new Rol(rol));
			loginService.ActualizarUsuarioNuevo(bean);
			redirect.addFlashAttribute("MENSAJE", "Se actualizaron sus datos correctamente: " + nom );
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "No se actualizaron sus datos, ingrese de nuevo: " + nom);
			e.printStackTrace();
		}
		return "redirect:/datos/";
	}
	
	
	
}
