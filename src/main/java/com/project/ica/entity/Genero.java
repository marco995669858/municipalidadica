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
@Table(name = "tb_genero")
public class Genero{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idgenero")
	private int CodGenero;

	@Column(name = "desgenero")
	private String NomGenero;

	@OneToMany(mappedBy = "tbGenero")
	@JsonIgnore
	private List<Usuario> listaUsuario;

	public Genero(int codGenero) {
		this.CodGenero = codGenero;
	}

	public Genero() {
	}

	public int getCodGenero() {
		return CodGenero;
	}

	public void setCodGenero(int codGenero) {
		CodGenero = codGenero;
	}


	public String getNomGenero() {
		return NomGenero;
	}

	public void setNomGenero(String nomGenero) {
		NomGenero = nomGenero;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public Usuario addUsuario(Usuario tbusuario) {
		getListaUsuario().add(tbusuario);
		tbusuario.setTbGenero(this);

		return tbusuario;
	}

	public Usuario removeUsuario(Usuario tbUsuario) {
		getListaUsuario().add(tbUsuario);
		tbUsuario.setTbGenero(this);

		return tbUsuario;
	}

}
