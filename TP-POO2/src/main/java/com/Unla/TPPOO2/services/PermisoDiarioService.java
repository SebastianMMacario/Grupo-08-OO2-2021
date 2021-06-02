package com.Unla.TPPOO2.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Unla.TPPOO2.interfaceService.IPermisoDiarioService;
import com.Unla.TPPOO2.interfaces.IPermisoDiario;
import com.Unla.TPPOO2.models.Lugar;
import com.Unla.TPPOO2.models.PermisoDiario;
import com.Unla.TPPOO2.models.PermisoPeriodo;
import com.Unla.TPPOO2.repositories.IPermisoDiarioRepository;

@Service
public class PermisoDiarioService implements IPermisoDiarioService {

	@Autowired
	private IPermisoDiario data;
	
	@Autowired
	private IPermisoDiarioRepository IPermisoDiarioRepository;
	
	@Override
	public List<PermisoDiario> listarPermisosDiarios() {
		return (List<PermisoDiario>) data.findAll();
	}
	
	@Override
	public List<PermisoDiario> traerPermisosDiariosPorFecha(String fechaDesde, String fechaHasta) {
		return IPermisoDiarioRepository.findPermisoDiarioByFechas(fechaDesde, fechaHasta);
	}

	@Override
	public List<PermisoDiario> traerPermisosDiariosPorFechaYLugar(String fechaDesde, String fechaHasta, String desdeHasta) {
		List<PermisoDiario> permisosDiarios = new ArrayList<PermisoDiario>();
		
		for(PermisoDiario pd: traerPermisosDiariosPorFecha(fechaDesde, fechaHasta)) {
			for(Lugar l: pd.getDesdeHasta()) {
				if(l.getLugar().equals(desdeHasta)) {
					permisosDiarios.add(pd);
				}
			}
		}
		return permisosDiarios;
	}

}
