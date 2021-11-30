package com.project.ica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.ica.entity.Solicitantes;

public interface SolicitanteDAO extends JpaRepository<Solicitantes, Integer>{
	
	@Query("select s from Solicitantes  s where s.estadoSolicitud.codsolicitud=?1")
	public List<Solicitantes> verestado(int codigo);
}
