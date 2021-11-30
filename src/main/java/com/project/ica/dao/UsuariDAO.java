package com.project.ica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.ica.entity.Enlace;
import com.project.ica.entity.Usuario;

public interface UsuariDAO extends JpaRepository<Usuario, Integer> {
	
	@Query("select u from Usuario u where u.Correo=?1")
	public Usuario iniciarSession(String login);
	
	@Query("select e from RolEnlace re join re.enlace e where re.rol.CodRol=?1")
	public List<Enlace> traearEnlaces(int idRol);
}
