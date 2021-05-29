package com.Unla.TPPOO2.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name="permiso")
@Inheritance( strategy = InheritanceType.JOINED)
public class Permiso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idPermiso;
	
	//protected Persona persona
	
	@Column(name = "fecha")
	protected LocalDate  fecha;
	
	
	//protected Set<Lugar> desdeHasta:
	
	
	public Permiso() {
		super();
	}
	
	
	public Permiso(int idPermiso, LocalDate fecha) {
		super();
		this.idPermiso = idPermiso;
		this.fecha = fecha;
	}


	public int getIdPermiso() {
		return idPermiso;
	}


	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Permiso [idPermiso=" + idPermiso + ", fecha=" + fecha + "]";
	}

	
	
}
