package com.umgprojects.controlcitas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umgprojects.controlcitas.repository.CitaRepository;
import com.umgprojects.controlcitas.entity.Cita;


@RestController
public class CitaController {

	
	private final CitaRepository repository;
	
	public CitaController(CitaRepository repository) {
		this.repository = repository;
	}
	
	
	@GetMapping("/citas")
	List<Cita> getAllCitas() {
		return repository.findAll();
	}
	
	@PostMapping("/citas")
	Cita crearCita(@RequestBody Cita nuevaCita) {
		return repository.save(nuevaCita);
	}
	
	
	@GetMapping("/citas/{id}")
	Cita getOneCita(@PathVariable Integer id) {
		return repository.getOne(id);
	}
	
	@PutMapping("/citas/{id}")
	Cita editarCita(@RequestBody Cita nuevaCita, @PathVariable Integer id) {
		Cita cita = repository.getOne(id);
		if(cita != null) {
			cita.setFecha(nuevaCita.getFecha());
			cita.setDescripcion(nuevaCita.getDescripcion());
			cita.setHora(nuevaCita.getHora());
			cita.setListaPaciente(nuevaCita.getListaPaciente());
			cita.setListaTrabajador(nuevaCita.getListaTrabajador());
			return repository.save(cita);
		} else {
			nuevaCita.setId(id);
			return repository.save(nuevaCita);
		}
	}
}
