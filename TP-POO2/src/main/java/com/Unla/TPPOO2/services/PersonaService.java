package com.Unla.TPPOO2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Unla.TPPOO2.interfaceService.IPersonaService;
import com.Unla.TPPOO2.interfaces.IPersona;
import com.Unla.TPPOO2.models.Persona;
import com.Unla.TPPOO2.repositories.IPersonaRepository;

@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	private IPersona  data;
	
	@Autowired
	private IPersonaRepository personaRepository;
	
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
	public Persona listarDNI(long dni) throws Exception {
		// TODO Auto-generated method stub
		Persona persona = personaRepository.findPersonaByDNI(dni);
		if(persona == null) throw new Exception("La persona con el dni: "+dni+" no se encuentra registrada");
		return persona;
	}
	
	@Override
	public int save(Persona p) throws Exception {
		// TODO Auto-generated method stub
		if (personaRepository.findPersonaByDNI(p.getDni())!=null) {
			throw new Exception("La persona con el dni: "+p.getDni()+" ya se encuentra registrada");
		}
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
