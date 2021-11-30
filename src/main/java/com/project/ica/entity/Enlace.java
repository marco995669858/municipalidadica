package com.project.ica.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_enlace")

public class Enlace  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idenlace")
	private int CodEnlace;

	@Column(name = "descripcion")
	private String Nombre;

	@Column(name = "ruta")
	private String ruta;

	@OneToMany(mappedBy = "enlace")
	private List<RolEnlace> listaRolEnlaces;

	public int getCodEnlace() {
		return CodEnlace;
	}

	public void setCodEnlace(int codEnlace) {
		CodEnlace = codEnlace;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public List<RolEnlace> getListaRolEnlaces() {
		return listaRolEnlaces;
	}

	public void setListaRolEnlaces(List<RolEnlace> listaRolEnlaces) {
		this.listaRolEnlaces = listaRolEnlaces;
	}

}
