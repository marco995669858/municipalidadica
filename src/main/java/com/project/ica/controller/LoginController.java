package com.project.ica.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ica.entity.Enlace;
import com.project.ica.entity.Genero;
import com.project.ica.entity.Rol;
import com.project.ica.entity.Usuario;
import com.project.ica.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	

	// para el login
	@RequestMapping(value = "/login")
	public String inicio() {

		return "LoginIca";
	}

	@RequestMapping(value = "/Ingresar")
	public String menu(Authentication auth,HttpServletRequest  request) {	
		// recuperar nombre del usuario
		String nomUsu = auth.getName();
		// invocar al metodo "iniciarsession"
		Usuario bean = usuarioService.iniciarSesion(nomUsu);
		// traer enlace segun el rol
		List<Enlace> lista = usuarioService.traearEnlaces(bean.getRol().getCodRol());
		HttpSession session = request.getSession();
		session.setAttribute("menus", lista);
		session.setAttribute("usuario", bean);
		
		return "redirect:/Principal/";
	}

	
	
	
	//para el registrar un nuevo usuario
	@RequestMapping(value = "/registrar")
	public String registrar(Model model) {
		model.addAttribute("genero", usuarioService.listaGenro());
		return "RegistroUsuario";
	}

	@PostMapping(value = "/registrarusuario")
	public String registrarusuario(@RequestParam("nombre") String nom, @RequestParam("apePaterno") String paterno,
			@RequestParam("apeMaterno") String materno, @RequestParam("dni") String dni,
			@RequestParam("email") String email, @RequestParam("password") String pass,
			@RequestParam("telefono") String tel, @RequestParam("fecha") String fecha,
			@RequestParam("genero") int codgenero, @RequestParam("rol") int rol, RedirectAttributes redirect) {

		try {

			Usuario bean = new Usuario();

			bean.setNomUser(nom);
			bean.setApePaterno(paterno);
			bean.setApeMaterno(materno);
			bean.setDniUser(dni);
			bean.setCorreo(email);
			bean.setPassword(passwordEncoder.encode(pass));
			bean.setCelular(tel);
			bean.setFechNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
			bean.setTbGenero(new Genero(codgenero));
			bean.setRol(new Rol(rol));
			usuarioService.registraUsuarioNuevo(bean);

			usuarioService.registraUsuarioNuevo(bean);
			redirect.addFlashAttribute("MENSAJE", "Se registro un nuevo usuario: " + nom + ' ' + paterno);

		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error al ingresar el usuario: " + nom);
			e.printStackTrace();
		}
		return "redirect:/registrar";
	}



}
