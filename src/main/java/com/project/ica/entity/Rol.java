package com.project.ica.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_rol")
public class Rol  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrol")
	private int CodRol;

	@Column(name = "descripcion")
	private String NomRol;


	@OneToMany(mappedBy = "rol")
	private List<Usuario> listaUsuarios;

	@OneToMany(mappedBy = "rol")
	private List<RolEnlace> listarRolEnlace;

	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	public Rol(int codRol) {
		this.CodRol = codRol;
	}

	public Rol() {
	}

	public int getCodRol() {
		return CodRol;
	}

	public void setCodRol(int codRol) {
		CodRol = codRol;
	}

	public String getNomRol() {
		return NomRol;
	}

	public void setNomRol(String nomRol) {
		NomRol = nomRol;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<RolEnlace> getListarRolEnlace() {
		return listarRolEnlace;
	}

	public void setListarRolEnlace(List<RolEnlace> listarRolEnlace) {
		this.listarRolEnlace = listarRolEnlace;
	}


	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
