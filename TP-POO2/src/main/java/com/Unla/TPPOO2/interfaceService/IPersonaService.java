package com.Unla.TPPOO2.interfaceService;

import java.util.List;
import java.util.Optional;

import com.Unla.TPPOO2.models.Persona;

public interface IPersonaService  {
	
	public List<Persona>listar();
	public Optional<Persona>listarId(int id);
	public Persona listarDNI(long dni) throws Exception;
	public int save(Persona p) throws Exception;
	public void delete(int id) throws Exception;
	
	
}