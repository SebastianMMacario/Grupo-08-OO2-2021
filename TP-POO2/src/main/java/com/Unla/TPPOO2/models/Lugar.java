package com.Unla.TPPOO2.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name="lugar")
public class Lugar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLugar;
	@Column(name="lugar",nullable = false,length = 45)
	private String lugar;
	
	@Column(name="codigoPostal",nullable = false,length = 45)
	private String codigoPostal;
	
	@ManyToMany
	@JoinTable(name = "permiso_lugar",joinColumns = @JoinColumn(name="idLugar"), inverseJoinColumns = @JoinColumn(name="idPermiso") )
	private Set<Permiso> permisos;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	
	public Lugar() {}

	public Lugar( String lugar, String codigoPostal, Set<Permiso> permisos) {
		super();
		
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
		this.permisos = permisos;
	}

	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}

	@Override
	public String toString() {
		return "Lugar [idLugar=" + idLugar + ", lugar=" + lugar + ", codigoPostal=" + codigoPostal + "]";
	}
	
	

}
