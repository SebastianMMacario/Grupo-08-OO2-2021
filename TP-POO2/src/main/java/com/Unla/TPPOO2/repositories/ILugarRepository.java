package com.Unla.TPPOO2.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Unla.TPPOO2.models.Lugar;




@Repository("lugarRepository")
public interface ILugarRepository extends JpaRepository<Lugar, Serializable>{
	Lugar findByLugarId(int idLugar);
}