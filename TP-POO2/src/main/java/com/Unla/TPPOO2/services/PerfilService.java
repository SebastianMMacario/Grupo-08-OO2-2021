package com.Unla.TPPOO2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Unla.TPPOO2.interfaceService.IPerfilService;
import com.Unla.TPPOO2.interfaces.IPerfil;
import com.Unla.TPPOO2.models.Perfil;
import com.Unla.TPPOO2.repositories.IPerfilRepository;


@Service
public class PerfilService implements IPerfilService {
	@Autowired
	private IPerfil data;

	@Autowired
	private IPerfilRepository perfilRespository;
	
	@Override
	public List<Perfil> listar() {
		// TODO Auto-generated method stub
		return (List<Perfil>) data.findAll();
	}

	@Override
	public Optional<Perfil> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Perfil p){
		// TODO Auto-generated method stub
		
		//return Integer.parseInt(data.save(p).toString());
		int res = 0;
		Perfil perfil=data.save( p);
		if(!perfil.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		if (listarId(id) == null)
			throw new Exception("El perfil con id: " + id + " no existe");
		else data.deleteById(id);
	}

	@Override
	public Perfil buscarPorTipoPerfil(String tipoPerfil) {
		// TODO Auto-generated method stub
		return perfilRespository.findByTipoPerfil(tipoPerfil);
	}

	
	
	
	
	

}
