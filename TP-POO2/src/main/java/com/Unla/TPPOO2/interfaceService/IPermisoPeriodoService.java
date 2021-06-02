package com.Unla.TPPOO2.interfaceService;

import java.time.LocalDate;
import java.util.List;

import com.Unla.TPPOO2.models.PermisoPeriodo;

public interface IPermisoPeriodoService {
	
	public List<PermisoPeriodo> listarPermisosPeriodo();

	List<PermisoPeriodo> traerPermisosPeriodoPorFecha(String fechaDesde, String fechaHasta);	
	List<PermisoPeriodo> traerPermisosPeriodoPorFechaYLugar(String fechaDesde, String fechaHasta, String desdeHasta);
	
}
