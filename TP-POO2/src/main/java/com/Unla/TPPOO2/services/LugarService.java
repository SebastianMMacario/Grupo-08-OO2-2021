package com.Unla.TPPOO2.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Unla.TPPOO2.interfaceService.ILugarService;
import com.Unla.TPPOO2.interfaces.ILugar;
import com.Unla.TPPOO2.models.Lugar;
import com.Unla.TPPOO2.repositories.ILugarRepository;


@Service
public class LugarService implements ILugarService {
	
	@Autowired
	private ILugarRepository lugarRespository;
	
	@Autowired
	private ILugar data;
	
	//lista auxiliar donde se guardan los lugares que se le agregaran al permiso, a la hora de crearlo
	Set<Lugar> lugaresAux = new HashSet<Lugar>();
	
	
	@Override
	public void guardarLugarEncontradoEnListAux(Lugar lugar) throws Exception {
		// TODO Auto-generated method stub
		boolean encontrado = false;
		Iterator<Lugar> iterator = this.lugaresAux.iterator();
		while(!encontrado && iterator.hasNext()) {
			Lugar l = iterator.next();
			if(l.getIdLugar() == lugar.getIdLugar()) {
				encontrado = true;
			}
		}
		
		if(encontrado) throw new Exception("El lugar ya se encuentra agregado");
		lugaresAux.add(lugar);
	}

	@Override
	public void guardarLugarEnBD(Lugar lugar) throws Exception {
		// TODO Auto-generated method stub
		if(lugarRespository.findByLugar(lugar.getLugar()) != null) throw new Exception("El lugar que quiere agregar ya existe");
		
		lugarRespository.save(lugar);
		lugaresAux.add(lugar);
	}

	@Override
	public Lugar buscarLugarPorNombre(String lugarNombre) throws Exception {
		// TODO Auto-generated method stub
		Lugar lugarBuscado = lugarRespository.findByLugar(lugarNombre);
		if(lugarBuscado == null) throw new Exception("El lugar no existe");
		return lugarBuscado;
	}

	@Override
	public Set<Lugar> buscarTodosLugaresDeListAux(){
		// TODO Auto-generated method stub
		return lugaresAux;
	}

	@Override
	public void borrarTodosLugaresDeListAux() {
		// TODO Auto-generated method stub
		lugaresAux.clear(); //limpia la list auxiliar una vez finalizada la operacion de agregar un permiso
	}

	@Override
	public List<Lugar> listar() {
		return (List<Lugar>) data.findAll();
	}

}
