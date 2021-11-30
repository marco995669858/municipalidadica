package com.project.ica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ica.entity.Estado;
import com.project.ica.entity.Rol;
import com.project.ica.service.ConsultasService;

@Controller
@RequestMapping("/rol")
public class RolAdministradorController {

	@Autowired
	private ConsultasService administradorService;

	@RequestMapping("/")
	private String index(Model model) {
		model.addAttribute("e", administradorService.listarEstados());
		model.addAttribute("r", administradorService.listarRoles());

		return "AdministradorRol";
	}

	@RequestMapping(value = "/Registrar")
	private String guardar(@RequestParam("rol") int cod, @RequestParam("nombre") String nom,
			@RequestParam("estado") int estado, RedirectAttributes redirect) {

		try {
			Rol bean = new Rol();

			bean.setNomRol(nom);
			bean.setEstado(new Estado(estado));

			if (cod != 0) {
				bean.setCodRol(cod);
				administradorService.ActulizarRol(bean);
				redirect.addFlashAttribute("MENSAJE", "Se actulizo Correctamente el rol : " + nom);
			} else {
				administradorService.regitrarRol(bean);
				redirect.addFlashAttribute("MENSAJE", "Se registro el rol : " + nom);
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error al guardar rol...");
			e.printStackTrace();
		}

		return "redirect:/rol/";
	}

	@RequestMapping(value = "/Eliminar")
	private String Eliminar(@RequestParam("rol") int cod, RedirectAttributes redirect) {
		try {
			administradorService.eliminarrol(cod);
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE", "Error en la eliminación");
		}
		return "redirect:/rol/";
	}
}
