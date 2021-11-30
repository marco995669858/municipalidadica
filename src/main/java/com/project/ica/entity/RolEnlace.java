package com.project.ica.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_rol_enlace")
public class RolEnlace  {
	
	@EmbeddedId
	private RolEnlacePk id;
	
	@ManyToOne
	@JoinColumn(name = "idrol", referencedColumnName = "idrol", insertable = false, updatable = false)
	private Rol rol; // asoc

	@ManyToOne
	@JoinColumn(name = "idenlace", referencedColumnName = "idenlace", insertable = false, updatable = false)
	private Enlace enlace; // Asoc

	
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Enlace getEnlace() {
		return enlace;
	}

	public void setEnlace(Enlace enlace) {
		this.enlace = enlace;
	}

	public RolEnlacePk getId() {
		return id;
	}

	public void setId(RolEnlacePk id) {
		this.id = id;
	}

}
