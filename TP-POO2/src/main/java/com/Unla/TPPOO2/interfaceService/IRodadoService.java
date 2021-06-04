package com.Unla.TPPOO2.interfaceService;

import java.util.List;
import java.util.Optional;

import com.Unla.TPPOO2.models.Rodado;

public interface IRodadoService {
	
	public List<Rodado>listar();
	public Optional<Rodado>listarId(int id);
	public Rodado listarDominio(String dominio) throws Exception;
	public int save(Rodado r) throws Exception;
	public void delete(int id) throws Exception;
	
}