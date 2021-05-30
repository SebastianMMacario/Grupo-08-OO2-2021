package com.Unla.TPPOO2.repositories;

import com.Unla.TPPOO2.models.Permiso;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

public interface IPermisoRepository extends JpaRepository<Permiso, Serializable> {

	Permiso findByIdPermiso(int idPermiso);
}