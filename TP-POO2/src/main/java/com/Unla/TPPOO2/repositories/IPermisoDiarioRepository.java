package com.Unla.TPPOO2.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Unla.TPPOO2.models.PermisoDiario;

@Repository("permisoDiarioRepository")
public interface IPermisoDiarioRepository extends JpaRepository<PermisoDiario, Serializable>{

	
	@Query(nativeQuery=true, value="SELECT p.*, pd.* FROM permiso p, permiso_diario pd WHERE p.id_permiso=pd.id_permiso_diario AND p.id_persona=(:idPersona)")
	public List<PermisoDiario> findPermisosByIdPersona(@Param("idPersona") int id);
	
	@Query(nativeQuery=true, value="SELECT p.*, pd.* FROM permiso p, permiso_diario pd WHERE p.id_permiso=pd.id_permiso_diario AND p.fecha BETWEEN (:fechaDesde) AND (:fechaHasta)")
	public List<PermisoDiario> findPermisosByFechas(@Param("fechaDesde") String fechaDesde, @Param("fechaHasta") String fechaHasta);
	
	@Query(nativeQuery=true, value="SELECT p.*, pd.* FROM permiso p, permiso_diario pd WHERE p.id_permiso=pd.id_permiso_diario AND p.id_permiso= (:idPermiso)")
	public PermisoDiario findPermisoByIdPermiso(@Param("idPermiso")int idPermiso);
	
}
