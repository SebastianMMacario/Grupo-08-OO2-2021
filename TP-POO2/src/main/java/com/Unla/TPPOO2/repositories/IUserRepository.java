package com.Unla.TPPOO2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Unla.TPPOO2.models.Usuario;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<Usuario, Serializable> {

	@Query("SELECT u FROM Usuario u JOIN FETCH u.perfil WHERE u.nombreUsuario = (:nombreUsuario)")
	public abstract Usuario findByUsernameAndFetchUserRolesEagerly(@Param("nombreUsuario") String nombreUsuario);
}
