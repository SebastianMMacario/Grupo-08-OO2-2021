package com.Unla.TPPOO2.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Unla.TPPOO2.interfaceService.IPermisoService;
import com.Unla.TPPOO2.interfaces.IPermiso;
import com.Unla.TPPOO2.models.Permiso;
import com.Unla.TPPOO2.repositories.IPermisoRepository;

@Service
public class PermisoService implements IPermisoService {
	@Autowired
	private IPermiso data;
	
	@Autowired
	private IPermisoRepository IPermisoRepository;

	@Override
	public List<Permiso> listar() {
		return (List<Permiso>) data.findAll();
	}

	@Override
	public Optional<Permiso> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public void delete(int id) throws Exception {
		if (listarId(id) == null)
			throw new Exception("El permiso con id: " + id + " no existe");
		else
			data.deleteById(id);
	}

	@Override
	public int save(Permiso p) throws Exception {		
		if(p.getDesdeHasta().size() < 2) throw new Exception("El permiso debe tener almenos 2 lugares agregados");
		
		int res = 0;
		Permiso permiso = data.save(p);
		if (!permiso.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public List<Permiso> traerPermisosPorPersona(int idPersona) {
		return IPermisoRepository.findPermisosByIdPersona(idPersona);
	}

	@Override
	public List<Permiso> traerPermisosPorRodado(int idRodado) {
		return IPermisoRepository.findPermisosByIdRodado(idRodado);
	}

	@Override
	public List<Permiso> traerPermisos(String fechaDesde, String fechaHasta, String desdeHasta) {

		List<Permiso> listaPermisos = (List<Permiso>) data.findAll();
		List<Permiso> listaPermisosAux = new ArrayList<Permiso>();
		LocalDate fDesde = LocalDate.parse(fechaDesde);
		LocalDate fHasta = LocalDate.parse(fechaHasta);
	
		if (desdeHasta != "") {
			listaPermisos = IPermisoRepository.findPermisoByLugar(desdeHasta);
		}
		Iterator<Permiso> it = listaPermisos.iterator();
		while (it.hasNext()) {
			Permiso p = (Permiso) it.next();
			
			if (Period.between(p.getFecha(), fDesde).getDays() <= 0 && 
				Period.between(p.getFecha(), fHasta).getDays() >= 0) {	
					listaPermisosAux.add(p);
			}
		}
		return listaPermisosAux;
	}
		
}
