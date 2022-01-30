package com.rbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rbs.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("Select u from Usuario u where u.login = ?1")
	Usuario findUserByLogin (String login);
}
