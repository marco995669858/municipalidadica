package com.project.ica.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ica.entity.EstadoSolicitud;
import com.project.ica.entity.Solicitantes;
import com.project.ica.service.ConsultasService;
import com.project.ica.service.UsuarioService;

@Controller
@RequestMapping(value = "/buzon")
public class BuzonEntradaController {

	@Autowired
	private UsuarioService loginService;

	@Autowired
	private ConsultasService consultasService;

	private String folder = "C:/pdf/";

	@RequestMapping(value = "/")
	public String buzon(Model model) {
		model.addAttribute("solicitante", loginService.listarSolicitante());
		model.addAttribute("estado", consultasService.estadosolicitud());
		return "BuzonEntrada";
	}

	@RequestMapping(value = "/actualizar")
	public String actualizar(@RequestParam("codigo") int cod, @RequestParam("nombre") String nom,
			@RequestParam("paterno") String pate, @RequestParam("materno") String mate,
			@RequestParam("correo") String email, @RequestParam("celular") String celu,
			@RequestParam("estado") int codEstado, @RequestParam("nuevocv") String cvantiguo,
			RedirectAttributes redirect) {

		try {

			Solicitantes bean = new Solicitantes();
			bean.setCodSolicitante(cod);
			bean.setNomSolicitante(nom);
			bean.setPaternoSolicitante(pate);
			bean.setMaternoSolicitante(mate);
			bean.setCorreoSolicitante(email);
			bean.setCelularSolicitante(celu);
			bean.setRuta(folder);
			bean.setNomArchivo(cvantiguo);
			bean.setEstadoSolicitud(new EstadoSolicitud(codEstado));
			loginService.registrarSolicitante(bean);
			redirect.addFlashAttribute("MENSAJE", "Se actualizo correctamente el usuario : " + nom);
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "No se actualizo correctamente el usuario : " + nom);
			e.printStackTrace();
		}

		return "redirect:/buzon/";
	}

	@GetMapping(value = "/descargar.pdf")
	@ResponseBody
	private ResponseEntity<Resource> pdf(@RequestParam("nombrepdf") String nombre) throws IOException {
		File file = new File("c:/pdf/" + nombre);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
	}
	
	@PostMapping(value = "/Eliminar")
	private String eliminar(@RequestParam("solicitante") int codigo,RedirectAttributes redirect) {
		try {
			loginService.eliminarSolicitante(codigo);
			redirect.addFlashAttribute("MENSAJE", "Se elimino el solicitante");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/buzon/";
	}
}
