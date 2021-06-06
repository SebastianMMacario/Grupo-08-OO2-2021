package com.Unla.TPPOO2.interfaceService;

import java.util.List;

import com.Unla.TPPOO2.models.PermisoDiario;
import com.Unla.TPPOO2.models.PermisoPeriodo;

public interface IPermisoPeriodoService {
	
	public List<PermisoPeriodo> listarPermisosPeriodo();

	List<PermisoPeriodo> traerPermisosPeriodoPorPersona(int idPersona);
	List<PermisoPeriodo> traerPermisosPeriodoPorRodado(int idRodado);
	List<PermisoPeriodo> traerPermisosPeriodoPorFecha(String fechaDesde, String fechaHasta);	
	List<PermisoPeriodo> traerPermisosPeriodoPorFechaYLugar(String fechaDesde, String fechaHasta, String desdeHasta);
	PermisoPeriodo traerPermisoPeriodoPorQR(int idPermiso);

	
}
