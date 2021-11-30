package com.project.ica.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class RolEnlacePk  implements Serializable{

	private int idrol;
	private int idenlace;

	@Override
	public int hashCode() {
		return Objects.hash(idenlace, idrol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolEnlacePk other = (RolEnlacePk) obj;
		return idenlace == other.idenlace && idrol == other.idrol;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public int getIdenlace() {
		return idenlace;
	}

	public void setIdenlace(int idenlace) {
		this.idenlace = idenlace;
	}
	
	

}
