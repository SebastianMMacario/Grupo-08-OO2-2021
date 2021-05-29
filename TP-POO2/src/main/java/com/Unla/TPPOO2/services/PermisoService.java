package com.Unla.TPPOO2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Unla.TPPOO2.interfaceService.IPermisoService;
import com.Unla.TPPOO2.interfaces.IPermiso;
import com.Unla.TPPOO2.models.Permiso;
import com.Unla.TPPOO2.models.PermisoDiario;
import com.Unla.TPPOO2.models.PermisoPeriodo;

@Service
public class PermisoService implements IPermisoService{
	@Autowired
	private IPermiso data;

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
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		if (listarId(id) == null)
			throw new Exception("El permiso con id: " + id + " no existe");
		else data.deleteById(id);
	}

	@Override
	public int savePermisoDiario(PermisoDiario pd) {
		// TODO Auto-generated method stub
		int res = 0;
		PermisoDiario permisoDiario=data.save( pd);
		if(!permisoDiario.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public int savePermisoPeriodo(PermisoPeriodo pp) {
		// TODO Auto-generated method stub
		int res = 0;
		PermisoPeriodo permisoPeriodo=data.save( pp);
		if(!permisoPeriodo.equals(null)) {
			res=1;
		}
		return res;
	}

}
