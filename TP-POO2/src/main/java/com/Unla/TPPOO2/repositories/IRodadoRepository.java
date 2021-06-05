package com.Unla.TPPOO2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Unla.TPPOO2.models.Rodado;

public interface IRodadoRepository extends JpaRepository<Rodado, Serializable>{
	
	
	@Query("SELECT r FROM Rodado r  WHERE  r.dominio = (:dominio)")
	public Rodado findRodadoByDominio(@Param("dominio")String dominio);
	
}
