package com.Unla.TPPOO2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Unla.TPPOO2.models.Perfil;

@Repository("perfilRepository")
public interface IPerfilRepository extends JpaRepository<Perfil, Serializable>{
	
	@Query("SELECT p FROM Perfil p  WHERE  p.tipoPerfil = (:tipoPerfil)")
	public Perfil findByTipoPerfil(@Param("tipoPerfil") String tipoPerfil);
}
