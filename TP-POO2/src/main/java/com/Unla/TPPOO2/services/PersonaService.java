package com.Unla.TPPOO2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.DatabaseStartupValidator;

import com.Unla.TPPOO2.interfaceService.IPersonaService;
import com.Unla.TPPOO2.interfaces.IPersona;
import com.Unla.TPPOO2.models.Perfil;
import com.Unla.TPPOO2.models.Persona;

public class PersonaService implements IPersonaService{
	
	@Autowired
	private IPersona  data;
	
	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return (List<Persona>) data.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Persona p) {
		// TODO Auto-generated method stub
		int res = 0;
		Persona persona=data.save( p);
		if(!persona.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		if (listarId(id) == null)
			throw new Exception("La persona con id: " + id + " no existe");
		else data.deleteById(id);
		
	}

}
