package com.Unla.TPPOO2.interfaceService;

import java.util.Set;

import com.Unla.TPPOO2.models.Lugar;

public interface ILugarService {
	public void guardarLugarEncontradoEnListAux(Lugar lugar) throws Exception;
	public void guardarLugarEnBD(Lugar lugar) throws Exception;
	public Lugar buscarLugarPorNombre(String lugarNombre) throws Exception;
	public Set<Lugar> buscarTodosLugaresDeListAux();
	public void borrarTodosLugaresDeListAux();
}
