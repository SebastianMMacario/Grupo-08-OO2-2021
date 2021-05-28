package com.Unla.TPPOO2.interfaceService;

import java.util.List;
import java.util.Optional;

import com.Unla.TPPOO2.models.Perfil;

public interface IPerfilService {
	
	public List<Perfil>listar();
	public Optional<Perfil>listarId(int id);
	public Perfil buscarPorTipoPerfil(String tipoPerfil);
	public int save(Perfil p);
	public void delete(int id) throws Exception;
	
}