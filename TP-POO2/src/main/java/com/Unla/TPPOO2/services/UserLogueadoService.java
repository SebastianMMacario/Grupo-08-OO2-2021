package com.Unla.TPPOO2.services;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;



import com.Unla.TPPOO2.interfaceService.IUserLogueadoService;
import com.Unla.TPPOO2.models.Usuario;
import com.Unla.TPPOO2.repositories.IUserRepository;

@Service
public class UserLogueadoService implements IUserLogueadoService{

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public Usuario traerUserLogueado() {

		String currentUserName = "";
		Usuario user = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			currentUserName = authentication.getName();
			user = userRepository.findByUsernameAndFetchUserRolesEagerly(currentUserName);
		}

		return user;		
	 
	};
		
		
		
}
	

