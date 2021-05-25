package com.Unla.TPPOO2.models;

import java.time.LocalDateTime;
import java.util.HashSet;
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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="perfil", uniqueConstraints=@UniqueConstraint(columnNames= {"tipo_perfil"}))
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;
	
	@Column(name="tipo_perfil", nullable=false, length=45)
	private String tipo_perfil;

	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="perfil")
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	public Perfil() {}
	
	public Perfil(int idPerfil, String tipo_perfil) {
		this.idPerfil = idPerfil;
		this.tipo_perfil = tipo_perfil;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setId(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getTipoPerfil() {
		return tipo_perfil;
	}

	public void setTipoPerfil(String tipo_perfil) {
		this.tipo_perfil = tipo_perfil;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
