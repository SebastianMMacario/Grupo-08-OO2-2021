package com.Unla.TPPOO2.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="permisoDiario")
@PrimaryKeyJoinColumn(name = "idPermisoDiario")
public class PermisoDiario extends Permiso {
	
	@Column(name = "motivo",nullable=false, length=60)
	private String motivo;

	public PermisoDiario(){}
	
	public PermisoDiario(Persona persona, LocalDate fecha, Set<Lugar> desdeHasta,String motivo) {
		super( persona, fecha,  desdeHasta);
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
