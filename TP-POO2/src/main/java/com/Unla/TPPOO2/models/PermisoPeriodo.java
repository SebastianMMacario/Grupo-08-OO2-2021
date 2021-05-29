package com.Unla.TPPOO2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "permisoPeriodo")
@PrimaryKeyJoinColumn(name = "idPermisoPeriodo")
public class PermisoPeriodo extends Permiso {
	@Column(name = "cantDias")
	private int cantDias;
	
	@Column(name = "vacacion")
	private boolean vacacion;
	
	//private Rodado rodado;
	
	
	public PermisoPeriodo(int cantDias, boolean vacacion) {
		super();
		this.cantDias = cantDias;
		this.vacacion = vacacion;
	}
	public PermisoPeriodo() {
		super();
	}
		
	public int getCantDias() {
		return cantDias;
	}
	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}
	public boolean isVacacion() {
		return vacacion;
	}
	public void setVacacion(boolean vacacion) {
		this.vacacion = vacacion;
	}
	
	@Override
	public String toString() {
		return "PermisoPeriodo [cantDias=" + cantDias + ", vacacion=" + vacacion + ", idPermiso=" + idPermiso
				+ ", fecha=" + fecha + "]";
	}
	
	
}
