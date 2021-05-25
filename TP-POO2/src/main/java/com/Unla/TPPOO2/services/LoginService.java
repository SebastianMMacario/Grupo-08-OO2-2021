package com.Unla.TPPOO2.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Unla.TPPOO2.models.Usuario;
import com.Unla.TPPOO2.repositories.IUserRepository;


@Service("userService")
public class LoginService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userRepository.findByUsernameAndFetchUserRolesEagerly(username);
		return buildUser(user, buildGrantedAuthorities(user.getPerfil().getUsuarios()));
	}
	
	private User buildUser(Usuario user, List<GrantedAuthority> grantedAuthorities) {
		return new User(user.getNombreUsuario(), user.getPassword(), user.isEnabled(),
						true, true, true, //accountNonExpired, credentialsNonExpired, accountNonLocked,
						grantedAuthorities);
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Set<Usuario> usuarios) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for(Usuario usuario: usuarios) {
			grantedAuthorities.add(new SimpleGrantedAuthority(usuario.getPerfil().getTipoPerfil()));
		}
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}
}
