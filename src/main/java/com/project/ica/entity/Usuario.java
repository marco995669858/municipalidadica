package com.project.ica.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int CodUsuario;

	@Column(name = "nom_usuario")
	private String NomUser;

	@Column(name = "apepaterno_usuario")
	private String ApePaterno;

	@Column(name = "apematerno_usuario")
	private String ApeMaterno;

	@Column(name = "dni_usuario")
	private String DniUser;

	@Column(name = "cuenta_usuario")
	private String Correo;

	@Column(name = "contrasenia_usuario")
	private String Password;

	@Column(name = "tel_usuario")
	private String Celular;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name = "fecha_nacimiento_usuario")
	private Date FechNacimiento;

	@ManyToOne
	@JoinColumn(name = "idgenero")
	private Genero tbGenero;

	@ManyToOne
	@JoinColumn(name = "idrol")
	private Rol rol;

	public int getCodUsuario() {
		return CodUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		CodUsuario = codUsuario;
	}

	public String getNomUser() {
		return NomUser;
	}

	public void setNomUser(String nomUser) {
		NomUser = nomUser;
	}

	public String getApePaterno() {
		return ApePaterno;
	}

	public void setApePaterno(String apePaterno) {
		ApePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return ApeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		ApeMaterno = apeMaterno;
	}

	public String getDniUser() {
		return DniUser;
	}

	public void setDniUser(String dniUser) {
		DniUser = dniUser;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getCelular() {
		return Celular;
	}

	public void setCelular(String celular) {
		Celular = celular;
	}

	public Date getFechNacimiento() {
		return FechNacimiento;
	}

	public void setFechNacimiento(Date fechNacimiento) {
		FechNacimiento = fechNacimiento;
	}

	public Genero getTbGenero() {
		return tbGenero;
	}

	public void setTbGenero(Genero tbGenero) {
		this.tbGenero = tbGenero;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
