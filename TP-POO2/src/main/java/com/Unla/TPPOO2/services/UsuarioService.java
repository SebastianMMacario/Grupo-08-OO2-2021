package com.Unla.TPPOO2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Unla.TPPOO2.interfaceService.IusuarioService;
import com.Unla.TPPOO2.interfaces.IUsuario;
import com.Unla.TPPOO2.models.Usuario;

@Service
public class UsuarioService implements IusuarioService {

	@Autowired
	private IUsuario data;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<Usuario> listar() {
		return (List<Usuario>) data.findAll();
	}

	@Override
	public Optional<Usuario> listarId(int id) {
		return data.findById(id);
	}

	
	@Override
	public int save(Usuario u) {
		int res=0;
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		Usuario usuario=data.save(u);
		if(!usuario.equals(null)) {
			res=1;
		}
		return res;
	}
	
	@Override
	public void delete(int id) {
		data.deleteById(id);
	}

}
