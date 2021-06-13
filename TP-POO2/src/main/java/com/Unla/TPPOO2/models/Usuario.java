package com.Unla.TPPOO2.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="nombre", nullable=false, length=45)
	private String nombre;
	
	@Column(name="apellido", nullable=false, length=45)
	private String apellido;
		
    @Column(name="tipo_documento", nullable = false )
    @Enumerated(value = EnumType.ORDINAL)
    private TipoDocumento tipoDocumento;
	
	
    public enum TipoDocumento {
        DNI,
        LIBRETA_CIVICA,
        CEDULA_DE_IDENTIDAD,
        PASAPORTE
    }
    
    
	@Column(name="nroDocumento", nullable=false)
	private int nroDocumento;
	
	@Column(name="email", nullable=false, length=45)
	private String email;
	
	@Column(name="nombreUsuario", nullable=false, length=45/*, unique = true*/)
	private String nombreUsuario;
	
	@Column(name="password", nullable=false, length=60)
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_perfil")
	private Perfil perfil;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
		
	public Usuario() {}

	public Usuario(String nombre, String apellido, int nroDocumento, String email,
			String nombreUsuario, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroDocumento = nroDocumento;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}
	
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", nroDocumento="
				+ nroDocumento + ", email=" + email + ", nombreUsuario=" + nombreUsuario + ", perfil=" + perfil
				+ ", enabled=" + enabled + "]";
	}

}