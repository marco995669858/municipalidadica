package com.project.ica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ica.dao.EstadoSolicitudDAO;
import com.project.ica.dao.EstadosRolDAO;
import com.project.ica.dao.RolDAO;
import com.project.ica.entity.Estado;
import com.project.ica.entity.EstadoSolicitud;
import com.project.ica.entity.Rol;

@Service
public class ConsultasService {
	
	@Autowired
	private EstadoSolicitudDAO estadoSolicitudDAO;
	
	@Autowired
	private RolDAO rolDAO;
	
	@Autowired
	private EstadosRolDAO estadosRolDAO;
	// para listar los estados del solicitante
	public List<EstadoSolicitud> estadosolicitud() {

		return estadoSolicitudDAO.findAll();
	}
	
	//para listar rol, actualizar, registrar, eliminar
	
	public List<Estado> listarEstados() {
		return estadosRolDAO.findAll();
	}
	
	public List<Rol> listarRoles() {
		return rolDAO.findAll();
	}

	
	public void regitrarRol(Rol bean) {
		rolDAO.save(bean);
		
	}

	
	public void ActulizarRol(Rol bean) {
		rolDAO.save(bean);
		
	}

	
	public void eliminarrol(int codigo) {
		rolDAO.deleteById(codigo);
		
	}
	
}
