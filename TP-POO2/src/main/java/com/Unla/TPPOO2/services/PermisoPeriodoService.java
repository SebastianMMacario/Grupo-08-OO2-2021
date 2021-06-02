package com.Unla.TPPOO2.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Unla.TPPOO2.interfaceService.IPermisoPeriodoService;
import com.Unla.TPPOO2.interfaces.IPermisoPeriodo;
import com.Unla.TPPOO2.models.Lugar;
import com.Unla.TPPOO2.models.PermisoPeriodo;

@Service
public class PermisoPeriodoService implements IPermisoPeriodoService {

	@Autowired
	private IPermisoPeriodo data;
	
	@Override
	public List<PermisoPeriodo> listarPermisosPeriodo() {
		return (List<PermisoPeriodo>) data.findAll();
	}

	@Override
	public List<PermisoPeriodo> traerPermisosPeriodoPorFecha(String fechaDesde, String fechaHasta) {
		
		List<PermisoPeriodo> permisosPeriodo = new ArrayList<PermisoPeriodo>();
		LocalDate fechaDesdeSel = LocalDate.parse(fechaDesde); // Fecha "Desde" seleccionada por el usuario
		LocalDate fechaHastaSel = LocalDate.parse(fechaHasta); // Fecha "Hasta" seleccionada por el usuario
		LocalDate fDesde, fHasta; // Fechas "Desde" y "Hasta" del Permiso
		
		for (PermisoPeriodo pp: data.findAll()) {
			fDesde = pp.getFecha();
			fHasta = fDesde.plusDays(pp.getCantDias());
			if(((Period.between(fDesde, fechaDesdeSel).getDays() <= 0) && 
				(Period.between(fDesde, fechaHastaSel).getDays() >= 0)) || 
				(Period.between(fHasta, fechaDesdeSel).getDays() <= 0) && 
				(Period.between(fHasta, fechaHastaSel).getDays() >= 0)) {
				
				permisosPeriodo.add(pp);
			}
		}	
		return permisosPeriodo;		
	}

	@Override
	public List<PermisoPeriodo> traerPermisosPeriodoPorFechaYLugar(String fechaDesde, String fechaHasta, String desdeHasta) {
		List<PermisoPeriodo> permisosPeriodo = new ArrayList<PermisoPeriodo>();

		for(PermisoPeriodo pp: traerPermisosPeriodoPorFecha(fechaDesde, fechaHasta)) {
			for(Lugar l: pp.getDesdeHasta()) {
				if(l.getLugar().equals(desdeHasta)) {
					permisosPeriodo.add(pp);
				}
			}	
		}
		return permisosPeriodo;
	}

}