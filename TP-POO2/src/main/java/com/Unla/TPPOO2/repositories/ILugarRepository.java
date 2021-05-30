package com.Unla.TPPOO2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Unla.TPPOO2.models.Lugar;

@Repository("lugarRepository")
public interface ILugarRepository extends JpaRepository<Lugar, Serializable>{
	
	@Query("SELECT l FROM Lugar l  WHERE  l.lugar = (:lugar)")
	public Lugar findByLugar(@Param("lugar") String lugar);
}
