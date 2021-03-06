package com.Unla.TPPOO2.interfaceService;

import java.util.List;

import com.Unla.TPPOO2.models.PermisoDiario;

public interface IPermisoDiarioService {

	public List<PermisoDiario> listarPermisosDiarios();

	List<PermisoDiario> traerPermisosDiariosPorPersona(int idPersona);
	List<PermisoDiario> traerPermisosDiariosPorFecha(String fechaDesde, String fechaHasta);
	List<PermisoDiario> traerPermisosDiariosPorFechaYLugar(String fechaDesde, String fechaHasta, String desdeHasta);
	PermisoDiario traerPermisoDiariosPorQR(int idPermiso);
	
}
