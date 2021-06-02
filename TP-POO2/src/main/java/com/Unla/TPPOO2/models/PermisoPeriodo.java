package com.Unla.TPPOO2.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="permisoPeriodo")
@PrimaryKeyJoinColumn(name = "idPermisoPeriodo")
public class PermisoPeriodo extends Permiso {
	@Column(name = "cantDias")
	private int cantDias;
	
	@Column(name = "vacacion",nullable=false, length=60)
	private boolean vacacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_rodado",nullable=false)
	private Rodado rodado;
	
	
	
	
	public PermisoPeriodo(Persona persona, LocalDate fecha, Set<Lugar> desdeHasta,int cantDias, boolean vacacion, Rodado rodado) {
		super( persona,  fecha, desdeHasta);
		this.cantDias = cantDias;
		this.vacacion = vacacion;
		this.rodado = rodado;
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
	
	public Rodado getRodado() {
		return rodado;
	}
	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}

	@Override
	public String toString() {
		return "PermisoPeriodo [cantDias=" + cantDias + ", vacacion=" + vacacion + ", rodado=" + rodado + "]";
	}
	
	
	
	
	
}
