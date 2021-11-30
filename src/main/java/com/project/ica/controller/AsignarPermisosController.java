package com.project.ica.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ica.entity.Genero;
import com.project.ica.entity.Rol;
import com.project.ica.entity.Usuario;
import com.project.ica.service.ConsultasService;
import com.project.ica.service.UsuarioService;

@Controller
@RequestMapping("/Permisos")
public class AsignarPermisosController {

	@Autowired
	private UsuarioService service;

	@Autowired
	private ConsultasService consultasService;

	@RequestMapping(value = "/")
	private String index(Model model) {
		model.addAttribute("u", service.listaUsuario());
		model.addAttribute("r", consultasService.listarRoles());
		model.addAttribute("g", service.listaGenro());
		return "AsignarRoles";
	}

	@PostMapping(value = "/Registrar")
	private String registrar(@RequestParam("codigo") int cod, @RequestParam("nombre") String nom,
			@RequestParam("paterno") String pat, @RequestParam("materno") String mat, @RequestParam("dni") String dni,
			@RequestParam("correo") String correo, @RequestParam("contra") String contra,
			@RequestParam("celular") String cel, @RequestParam("fecha") String fecha,
			@RequestParam("genero") int genero, @RequestParam("rol") int rol, RedirectAttributes redirect) {

		try {
			Usuario bean = new Usuario();
			bean.setCodUsuario(cod);
			bean.setNomUser(nom);
			bean.setApePaterno(pat);
			bean.setApeMaterno(mat);
			bean.setDniUser(dni);
			bean.setCorreo(correo);
			bean.setPassword(contra);
			bean.setCelular(cel);
			bean.setFechNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
			bean.setTbGenero(new Genero(genero));
			bean.setRol(new Rol(rol));
			service.ActualizarUsuarioNuevo(bean);
			redirect.addFlashAttribute("MENSAJE", "Se Actualizo el Usuario: " + nom + ' ' + pat + ' ' + mat);

		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "No se Actualizo el Usuario: " + nom + ' ' + pat + ' ' + mat);
			e.printStackTrace();
		}

		return "redirect:/Permisos/";
	}

	@PostMapping(value = "/Eliminar")
	private String eliminar(@RequestParam("codigoUsuario") int cod, RedirectAttributes redirect) {
		
		try {
			service.eliminarUsuario(cod);
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE", "Error en la eliminación");
		}
		
		return"redirect:/Permisos/";
	}
}
