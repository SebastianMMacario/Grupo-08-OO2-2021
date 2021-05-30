package com.Unla.TPPOO2.interfaceService;

import java.util.List;
import java.util.Optional;

import com.Unla.TPPOO2.models.Permiso;
import com.Unla.TPPOO2.models.PermisoDiario;
import com.Unla.TPPOO2.models.PermisoPeriodo;

public interface IPermisoService {
	
	public List<Permiso>listar();
	public Optional<Permiso>listarId(int id);
	public int savePermisoDiario(PermisoDiario pd);
	public int savePermisoPeriodo(PermisoPeriodo pp);
	public void delete(int id) throws Exception;
	int savePermiso(Permiso p);
	
}