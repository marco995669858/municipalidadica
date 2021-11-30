package com.project.ica.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_estado_solicitud")
public class EstadoSolicitud {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codsolicitud")
	private int codsolicitud;

	@Column(name = "nom_estadosolicitud")
	private String nombreSolicitud;
	
	@JsonIgnore
	@OneToMany(mappedBy = "estadoSolicitud")
	private List<Solicitantes> solicitante;
	
	public EstadoSolicitud(int codsolicitud) {
		this.codsolicitud = codsolicitud;
	}
	
	public EstadoSolicitud() {}

	

	public int getCodsolicitud() {
		return codsolicitud;
	}

	public void setCodsolicitud(int codsolicitud) {
		this.codsolicitud = codsolicitud;
	}

	public String getNombreSolicitud() {
		return nombreSolicitud;
	}

	public void setNombreSolicitud(String nombreSolicitud) {
		this.nombreSolicitud = nombreSolicitud;
	}

	public List<Solicitantes> getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(List<Solicitantes> solicitante) {
		this.solicitante = solicitante;
	}

//	public Solicitante addSolicitante(Solicitante solicitante) {
//		getSolicitante().add(solicitante);
//		solicitante.setEstadoSolicitud(this);
//
//		return solicitante;
//	}
//
//	public Solicitante removeSolicitante(Solicitante solicitante) {
//		getSolicitante().add(solicitante);
//		solicitante.setEstadoSolicitud(this);
//
//		return solicitante;
//	}

}
