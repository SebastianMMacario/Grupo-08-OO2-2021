package com.Unla.TPPOO2.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="rodado")
public class Rodado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRodado;
	
	@Column(name="dominio", nullable=false, length=45)
	private String dominio;
	
	@Column(name="vehiculo", nullable=false, length=45)
	private String vehiculo;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="rodado")
	private Set<PermisoPeriodo> permisosPeriodo;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Rodado() {}

	public Rodado( String dominio, String vehiculo, Set<PermisoPeriodo> permisosPeriodo) {
		super();
		this.dominio = dominio;
		this.vehiculo = vehiculo;
		this.permisosPeriodo = permisosPeriodo;
	}

	public int getIdRodado() {
		return idRodado;
	}

	public void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Set<PermisoPeriodo> getPermisosPeriodo() {
		return permisosPeriodo;
	}

	public void setPermisosPeriodo(Set<PermisoPeriodo> permisosPeriodo) {
		this.permisosPeriodo = permisosPeriodo;
	}
	

	@Override
	public String toString() {
		return "Rodado [idRodado=" + idRodado + ", dominio=" + dominio + ", vehiculo=" + vehiculo + "]";
	}
	
	

	
	
	
	
	

}
