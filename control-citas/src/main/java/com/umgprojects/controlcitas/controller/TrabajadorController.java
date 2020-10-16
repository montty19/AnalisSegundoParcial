package com.umgprojects.controlcitas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umgprojects.controlcitas.entity.Trabajador;
import com.umgprojects.controlcitas.repository.TrabajadorRepository;


@RestController
public class TrabajadorController {

	private final TrabajadorRepository repository;
	
	public TrabajadorController(TrabajadorRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/trabajadores")
	List<Trabajador> getAllTrabajadores() {
		return repository.findAll();
	}
	
	@PostMapping("/trabajadores")
	Trabajador crearTrabajador(@RequestBody Trabajador nuevoTrabajador) {
		return repository.save(nuevoTrabajador);
	}
	
	@GetMapping("/trabajadores/{id}")
	Trabajador getOneTrabajador(@PathVariable Integer id) {
		return repository.getOne(id);
	} 
	
	@PutMapping("/trabajadores/{id}")
	Trabajador editarTrabajador(@RequestBody Trabajador nuevoTrabajador, @PathVariable Integer id) {
		Trabajador trabajador = repository.getOne(id);
		if(trabajador != null) {
			trabajador.setUsuario(nuevoTrabajador.getUsuario());
			trabajador.setPassword(nuevoTrabajador.getPassword());
			trabajador.setNombre(nuevoTrabajador.getNombre());
			trabajador.setApellido(nuevoTrabajador.getApellido());
			trabajador.setDpi(nuevoTrabajador.getDpi());
			trabajador.setTelefono(nuevoTrabajador.getTelefono());
			trabajador.setListRole(nuevoTrabajador.getListRole());
			return repository.save(trabajador);
		} else {
			nuevoTrabajador.setId(id);
			return repository.save(nuevoTrabajador);
		}
	} 
	
}
