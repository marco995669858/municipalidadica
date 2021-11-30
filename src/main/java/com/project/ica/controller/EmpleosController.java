package com.project.ica.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ica.entity.EstadoSolicitud;
import com.project.ica.entity.Solicitantes;
import com.project.ica.pdf.UploadService;
import com.project.ica.service.ConsultasService;
import com.project.ica.service.UsuarioService;

@Controller
@RequestMapping("/Empleos")
public class EmpleosController {

	@Autowired
	private UsuarioService loginService;
	
	@Autowired
	private ConsultasService consultasService;
	
	@Autowired
	private UploadService upload;
	
	private String folder="C:/Users/51917/Pictures/Proyecto_Ica/Proyecto-ICA/cargas";
	
	@RequestMapping(value = "/")
	private String empleos(Model model) {
		model.addAttribute("estado", consultasService.estadosolicitud());
		return "Empleos";
	}

	@PostMapping(value = "/registro")
	public String registroEmpleos(@RequestParam("nombre") String nom, @RequestParam("apePaterno") String paterno,
			@RequestParam("apeMaterno") String materno, @RequestParam("correo") String email,
			@RequestParam("celular") String cel, @RequestParam("archivos") MultipartFile cv,
			@RequestParam("estadosolicitante") int estado, RedirectAttributes redirect) {

		try {
			
			if (!cv.isEmpty()) {
				try {
					byte [] bytes= cv.getBytes();
					Path path = Paths.get( folder+cv.getOriginalFilename());
					Files.write(path, bytes);				
									
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			Solicitantes bean = new Solicitantes();
			bean.setNomSolicitante(nom);
			bean.setPaternoSolicitante(paterno);
			bean.setMaternoSolicitante(materno);
			bean.setCorreoSolicitante(email);
			bean.setCelularSolicitante(cel);
			bean.setRuta(folder);
			bean.setNomArchivo(cv.getOriginalFilename());
			bean.setEstadoSolicitud(new EstadoSolicitud(estado));
			loginService.registrarSolicitante(bean);
			redirect.addFlashAttribute("MENSAJE", "Se registro su solicitud: " + nom);
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "No se registro su solicitud: " + nom);
			e.printStackTrace();
		}

		return "redirect:/Empleos/";
	}


}
