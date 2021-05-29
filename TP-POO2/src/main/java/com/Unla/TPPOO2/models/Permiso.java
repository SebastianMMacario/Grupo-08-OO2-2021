package com.Unla.TPPOO2.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="permiso")
@Inheritance( strategy = InheritanceType.JOINED)
public class Permiso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idPermiso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_persona",nullable=false)
	protected Persona persona;
	
	@Column(name = "fecha", nullable=false)
	protected LocalDate  fecha;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@ManyToMany
	@JoinTable(name = "permiso_lugar",joinColumns = @JoinColumn(name="idPermiso"), inverseJoinColumns = @JoinColumn(name="idLugar") )
	protected Set<Lugar> desdeHasta;

	
	
	public Permiso() {
		super();
	}
	
	
	


	public Permiso( Persona persona, LocalDate fecha, Set<Lugar> desdeHasta) {
		super();
		this.persona = persona;
		this.fecha = fecha;
		this.desdeHasta = desdeHasta;
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
	
	


	public Persona getPersona() {
		return persona;
	}





	public void setPersona(Persona persona) {
		this.persona = persona;
	}





	public Set<Lugar> getDesdeHasta() {
		return desdeHasta;
	}





	public void setDesdeHasta(Set<Lugar> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}





	@Override
	public String toString() {
		return "Permiso [idPermiso=" + idPermiso + ", persona=" + persona + ", fecha=" + fecha + "]";
	}





	





	
	
	
}
