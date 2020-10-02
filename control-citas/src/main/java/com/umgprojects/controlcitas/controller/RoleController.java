package com.umgprojects.controlcitas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umgprojects.controlcitas.entity.Role;
import com.umgprojects.controlcitas.repository.RoleRepository;

@RestController
public class RoleController {

	private final RoleRepository repository;
	
	public RoleController(RoleRepository repository) {
		this.repository = repository;
	}
	
	
	@GetMapping("/roles")
	List<Role> getAll() {
		return repository.findAll();
	}
	
	@PostMapping("/roles") 
	Role crearRole(@RequestBody Role role) {
		return repository.save(role);
	}

	@GetMapping("/roles/{id}")
	Role getOneRole(@PathVariable Integer id) {
		return repository.getOne(id);
	}
	
	@PutMapping("/roles/{id}")
	Role editarRole(@RequestBody Role nuevoRole, @PathVariable Integer id) {
		Role role = repository.getOne(id);
		if(role != null) {
			role.setDescripcion(nuevoRole.getDescripcion());
			return repository.save(role);
		} else {
			nuevoRole.setId(id);
			return repository.save(nuevoRole);
		}
	}
	
}
