package com.Unla.TPPOO2.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Unla.TPPOO2.interfaceService.IPermisoService;
import com.Unla.TPPOO2.interfaces.IPermiso;
import com.Unla.TPPOO2.models.Permiso;
import com.Unla.TPPOO2.models.Persona;
import com.Unla.TPPOO2.repositories.IPermisoRepository;

@Service
public class PermisoService implements IPermisoService {
	@Autowired
	private IPermiso data;
	
	@Autowired
	private IPermisoRepository IPermisoRepository;

	@Override
	public List<Permiso> listar() {
		// TODO Auto-generated method stub
		return (List<Permiso>) data.findAll();
	}

	@Override
	public Optional<Permiso> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	
	
	@Override
	public List<Permiso> traerPermisos(String fechaDesde, String fechaHasta, String desdeHasta) {
		// Permiso permiso = new Permiso();
//		List<Permiso> permiso69 = new ArrayList<>();

		List<Permiso> listaPermisos;
		List<Permiso> listaPermisosAux = new ArrayList<Permiso>();
		LocalDate fDesde = LocalDate.parse(fechaDesde);
		LocalDate fHasta = LocalDate.parse(fechaHasta);

		System.out.println("Hola");
//		Permiso permiso = new Permiso();
		// fechaHasta = fechaDesde + cantDias;
		
			listaPermisos = (List<Permiso>) data.findAll();
	
		
		if (desdeHasta != "") {
			listaPermisos = IPermisoRepository.findPermisoByLugar(desdeHasta);
		}
		System.out.println("Antes del iterator");
		Iterator<Permiso> it = listaPermisos.iterator();
		while (it.hasNext()) {

			Permiso p = (Permiso) it.next();
			System.out.println(p);

			if (Period.between(p.getFecha(), fHasta).getDays() >= 0) {
				System.out.println("Hola2");
				if (Period.between(p.getFecha(), fDesde).getDays() <= 0) {
					// if(ChronoUnit.DAYS.between(p.getFecha(), fHasta) > 0) {
					// ILugarRepository.findByLugar(desdeHasta); //ESTO
					// if(ChronoUnit.DAYS.between(p.getFecha(), fDesde) < 0) {

					System.out.println("Hola3");
					listaPermisosAux.add(p);
				}
			}
		}

//			LocalDate fecha = new LocalDate();
//		permiso = permisoRepository.findByDates(); //ESTO
//		System.out.println(permiso);
//		List<Permiso> listaPermisos = new ArrayList<Permiso>();
//		listaPermisos.add(permiso);
//		return listaPermisos;

		return listaPermisosAux;
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		if (listarId(id) == null)
			throw new Exception("El permiso con id: " + id + " no existe");
		else
			data.deleteById(id);
	}

	@Override
	public int save(Permiso p) throws Exception {
		// TODO Auto-generated method stub
		if(p.getDesdeHasta().isEmpty()) throw new Exception("El permiso debe tener almenos un lugar asignado");
		
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

}
