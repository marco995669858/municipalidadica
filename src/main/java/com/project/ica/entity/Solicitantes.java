package com.project.ica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_solicitante")
public class Solicitantes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codsolicitante")
	private int codSolicitante;

	@Column(name = "nomsolicitante")
	private String nomSolicitante;

	@Column(name = "paterno")
	private String PaternoSolicitante;

	@Column(name = "materno")
	private String MaternoSolicitante;

	@Column(name = "correo")
	private String CorreoSolicitante;

	@Column(name = "celular")
	private String CelularSolicitante;

	@Column(name = "ruta")
	private String ruta;

	@Column(name = "nombrearchivo")
	private String nomArchivo;

	@ManyToOne
	@JoinColumn(name = "codsolicitud")
	private EstadoSolicitud estadoSolicitud;

	
	public int getCodSolicitante() {
		return codSolicitante;
	}

	public void setCodSolicitante(int codSolicitante) {
		this.codSolicitante = codSolicitante;
	}

	public String getNomSolicitante() {
		return nomSolicitante;
	}

	public void setNomSolicitante(String nomSolicitante) {
		this.nomSolicitante = nomSolicitante;
	}

	public String getPaternoSolicitante() {
		return PaternoSolicitante;
	}

	public void setPaternoSolicitante(String paternoSolicitante) {
		PaternoSolicitante = paternoSolicitante;
	}

	public String getMaternoSolicitante() {
		return MaternoSolicitante;
	}

	public void setMaternoSolicitante(String maternoSolicitante) {
		MaternoSolicitante = maternoSolicitante;
	}

	public String getCorreoSolicitante() {
		return CorreoSolicitante;
	}

	public void setCorreoSolicitante(String correoSolicitante) {
		CorreoSolicitante = correoSolicitante;
	}

	public String getCelularSolicitante() {
		return CelularSolicitante;
	}

	public void setCelularSolicitante(String celularSolicitante) {
		CelularSolicitante = celularSolicitante;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getNomArchivo() {
		return nomArchivo;
	}

	public void setNomArchivo(String nomArchivo) {
		if(nomArchivo != "") {
		this.nomArchivo = nomArchivo;
		} else {
			this.nomArchivo = getNomArchivo();
		}
	}

	public EstadoSolicitud getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

}
