package com.Unla.TPPOO2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DatabaseDriver;

import com.Unla.TPPOO2.interfaceService.IRodadoService;
import com.Unla.TPPOO2.interfaces.IRodado;
import com.Unla.TPPOO2.models.Persona;
import com.Unla.TPPOO2.models.Rodado;

public class RodadoService implements IRodadoService {
	
	@Autowired
	private IRodado data;

	@Override
	public List<Rodado> listar() {
		// TODO Auto-generated method stub
		return (List<Rodado>) data.findAll();
	}

	@Override
	public Optional<Rodado> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Rodado r) {
		// TODO Auto-generated method stub
		int res = 0;
		Rodado rodado=data.save( r);
		if(!rodado.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		if (listarId(id) == null)
			throw new Exception("El rodado con id: " + id + " no existe");
		else data.deleteById(id);
	}

}
