package com.project.ica.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.ica.entity.Solicitantes;
import com.project.ica.service.ConsultasService;
import com.project.ica.service.UsuarioService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/consultas")
public class ConsultasController {
	
	@Autowired
	private ConsultasService consultasService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value =  "/")
	private String Consultas(Model model) {
		model.addAttribute("estado", consultasService.estadosolicitud());
		return "Consultas";
	}
	
	@RequestMapping(value = "/Solicitud")
	@ResponseBody
	private List<Solicitantes> consultar(@RequestParam("cod") int codigo) {
		List<Solicitantes> bean=null;
		try {
			bean=usuarioService.verestado(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@RequestMapping("/reporte")
	public void medicamentos(HttpServletResponse response,@RequestParam("codigo") int cod) {
		try {
			List<Solicitantes> lista=usuarioService.verestado(cod);
			File file=ResourceUtils.getFile("classpath:SolicitanteReporte.jrxml");
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource data=new JRBeanCollectionDataSource(lista);
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,null, data); 
			response.setContentType("application/pdf");
			OutputStream salida=response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, salida);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
