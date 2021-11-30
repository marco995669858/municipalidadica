package com.project.ica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ica.dao.GeneroDAO;
import com.project.ica.dao.SolicitanteDAO;
import com.project.ica.dao.UsuariDAO;
import com.project.ica.entity.Enlace;
import com.project.ica.entity.Genero;
import com.project.ica.entity.Solicitantes;
import com.project.ica.entity.Usuario;

@Service
public class UsuarioService {

	// esto es para registrar un nuevo usuario
	@Autowired
	private UsuariDAO usuariDAO;

	@Autowired
	private GeneroDAO generoDAO;
	
	//para el iniciar sessión
	public Usuario iniciarSesion(String login) {
		// TODO Auto-generated method stub
		return usuariDAO.iniciarSession(login);
	}
	
	//para traer los enlaces
	public List<Enlace> traearEnlaces(int idRol) {
		return usuariDAO.traearEnlaces(idRol);
	}

	// para el registrar un nuevo usuario
	public void registraUsuarioNuevo(Usuario bean) {
		usuariDAO.save(bean);
	}
	
	//para eliminar un usuario
	public void eliminarUsuario(int bean) {
		usuariDAO.deleteById(bean);
	}
	
	//para listar todos los usuarios
	public List<Usuario> listaUsuario() {
		return usuariDAO.findAll();
	}

	public void ActualizarUsuarioNuevo(Usuario bean) {
		usuariDAO.save(bean);
	}

	public List<Genero> listaGenro() {
		return generoDAO.findAll();
	}

	// esto es para el registrar un nuevo solicitante
	@Autowired
	private SolicitanteDAO solicitanteDAO;

	// para el registrar un nuevo solicitante
	public void registrarSolicitante(Solicitantes bean) {
		solicitanteDAO.save(bean);

	}

	// para el listar estado segun la consulta

	public List<Solicitantes> verestado(int codigo) {

		return solicitanteDAO.verestado(codigo);
	}

	// para listar los solicitantes
	public List<Solicitantes> listarSolicitante() {
		return solicitanteDAO.findAll();
	}
	
	//para eliminar el solicitante
	public void eliminarSolicitante(int codigo) {
		 solicitanteDAO.deleteById(codigo);
	}

}
