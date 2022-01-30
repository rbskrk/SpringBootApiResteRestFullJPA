package com.rbs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbs.model.Usuario;
import com.rbs.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	// Tratar excessão retorno null
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> findById(@PathVariable(value = "id") Long id) {
		Optional<Usuario> usuario = service.findById(id);
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}

	// Tratar excessão retorno null
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> listUsers = service.findAll();
		return new ResponseEntity<List<Usuario>>(listUsers, HttpStatus.OK);
	}

	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario user) {
		
		for (int pos = 0; pos < user.getTelefones().size(); pos ++) {
			user.getTelefones().get(pos).setUsuario(user);
		}
		
		Usuario usuario = service.saveUser(user);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

	}

	@PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> updateUser(@RequestBody Usuario user) {
		
		for (int pos = 0; pos < user.getTelefones().size(); pos ++) {
			user.getTelefones().get(pos).setUsuario(user);
		}
		
		Usuario usuario = service.updateUser(user);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

	}

	@DeleteMapping(value = "/{id}", produces = "application/text")
	public ResponseEntity delete(@PathVariable(value = "id") Long id) {
		 service.delete(id);
		 return new ResponseEntity(HttpStatus.OK);

	}

}
