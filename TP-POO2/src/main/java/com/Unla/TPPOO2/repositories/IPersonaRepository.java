package com.Unla.TPPOO2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Unla.TPPOO2.models.Persona;

@Repository("personaRepository")
public interface IPersonaRepository extends JpaRepository<Persona, Serializable>{
	
	@Query("SELECT p FROM Persona p  WHERE  p.dni = (:dni)")
	public Persona findPersonaByDNI(@Param("dni")long dni);
}

