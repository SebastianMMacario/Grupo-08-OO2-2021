package com.Unla.TPPOO2.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Unla.TPPOO2.models.PermisoDiario;
import com.Unla.TPPOO2.models.PermisoPeriodo;

@Repository("permisoPeriodoRepository")
public interface IPermisoPeriodoRepository extends JpaRepository<PermisoPeriodo, Serializable>{

	@Query(nativeQuery=true, value="SELECT * from permiso_periodo")
	public List<PermisoPeriodo> findAll();
	
	@Query(nativeQuery=true, value="SELECT p.*, pp.* FROM permiso p, permiso_periodo pp WHERE p.id_permiso=pp.id_permiso_periodo AND p.id_persona=(:idPersona)")
	public List<PermisoPeriodo> findPermisosByIdPersona(@Param("idPersona") int id);
	
	@Query(nativeQuery=true, value="SELECT p.*, pp.* FROM permiso p, permiso_periodo pp WHERE p.id_permiso=pp.id_permiso_periodo AND pp.id_rodado=(:idRodado)")
	public List<PermisoPeriodo> findPermisosByIdRodado(@Param("idRodado") int id);
	
	@Query(nativeQuery=true, value="SELECT p.*, pp.* FROM permiso p, permiso_periodo pp WHERE p.id_permiso=pp.id_permiso_periodo AND p.id_permiso= (:idPermiso)")
	public PermisoPeriodo findPermisoByIdPermiso(@Param("idPermiso")int idPermiso);
	
}
