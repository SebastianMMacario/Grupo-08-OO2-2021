package com.Unla.TPPOO2.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "permisoDiario")
@PrimaryKeyJoinColumn(name = "idPermisoDiario")
public class PermisoDiario extends Permiso {
	
	@Column(name = "motivo")
	private String motivo;

	public PermisoDiario(int idPermiso, LocalDate fecha, String motivo) {
		super(idPermiso,fecha);
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "PermisoDiario [motivo=" + motivo + ", idPermiso=" + idPermiso + ", fecha=" + fecha + "]";
	}
	
	
	
}
