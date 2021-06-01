package com.Unla.TPPOO2.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Unla.TPPOO2.models.Lugar;
import com.Unla.TPPOO2.models.Permiso;

@Repository("permisoRepository")
public interface IPermisoRepository extends JpaRepository<Permiso, Serializable>{
	
	@Query(nativeQuery=true, value="SELECT p.* from permiso p join permiso_lugar pl on p.id_permiso = pl.id_permiso join lugar l on pl.id_lugar = l.id_lugar where l.lugar = (:lugar)")
	public List<Permiso> findPermisoByLugar(@Param("lugar") String lugar);
	
	//@Query(nativeQuery=true, value="SELECT p.* from permiso p join permiso_periodo pp on p.id_permiso = pp.id_permiso_periodo join rodado r on pp.id_rodado = r.id_rodado where r.dominio = (:dominio)")
	//public List<Permiso> findPermisoByRodado(@Param("dominio") String dominio);
	
//	@Query(nativeQuery=true, value="SELECT * from permiso p, permiso_periodo pp where p.id_permiso = pp.id_permiso_periodo and pp.id_rodado = (:id)")
//	public List<Permiso> findPermisoByRodado(@Param("id") int id);


}