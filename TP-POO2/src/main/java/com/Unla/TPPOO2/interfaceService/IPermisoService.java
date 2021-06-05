package com.Unla.TPPOO2.interfaceService;

import java.util.List;
import java.util.Optional;

import com.Unla.TPPOO2.models.Permiso;


public interface IPermisoService {
	
	public List<Permiso>listar();
	public Optional<Permiso>listarId(int id);
	public int save(Permiso p) throws Exception;
	public void delete(int id) throws Exception;
	public List<Permiso> traerPermisosPorPersona(int idPersona);
	public List<Permiso> traerPermisosPorRodado(int idRodado);
	public List<Permiso> traerPermisos(String fechaDesde, String fechaHasta, String desdeHasta);
	
}