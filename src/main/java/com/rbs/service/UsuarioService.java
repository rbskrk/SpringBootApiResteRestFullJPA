package com.rbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rbs.model.Usuario;
import com.rbs.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public Optional<Usuario> findById(Long id) {
		return repository.findById(id);
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario saveUser(Usuario user) {
		return repository.save(user);
	}

	public Usuario updateUser(Usuario user) {
		return repository.save(user);
	}

	public void  delete(Long id) {
		repository.deleteById(id);
	}
	
}
