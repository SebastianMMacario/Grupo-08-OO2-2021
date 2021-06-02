package com.Unla.TPPOO2.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Unla.TPPOO2.models.PermisoPeriodo;

@Repository("permisoPeriodoRepository")
public interface IPermisoPeriodoRepository extends JpaRepository<PermisoPeriodo, Serializable>{

	@Query(nativeQuery=true, value="SELECT * from permiso_periodo")
	public List<PermisoPeriodo> findAll();
}
