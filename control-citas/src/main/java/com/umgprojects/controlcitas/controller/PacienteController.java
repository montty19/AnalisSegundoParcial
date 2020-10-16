package com.umgprojects.controlcitas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umgprojects.controlcitas.repository.*;
import com.umgprojects.controlcitas.entity.*;
import java.util.List;

@RestController
public class PacienteController {
	
	private final PacienteRepository repository; 
	
	public PacienteController(PacienteRepository repository) {
		this.repository = repository;
	}
	
	
	@GetMapping("/pacientes")
	List<Paciente> getAll() {
		return this.repository.findAll();
	}
	
	@PostMapping("/pacientes")
	Paciente crearPaciente(@RequestBody Paciente nuevoPaciente) {
		return repository.save(nuevoPaciente);
	}
	
	@GetMapping("/pacientes/{id}")
	Paciente unoPaciente(@PathVariable Integer id) {
		return repository.getOne(id);
	}
	
	@PutMapping("/pacientes/{id}")
	Paciente editarPaciente(@RequestBody Paciente nuevoPaciente, @PathVariable Integer id) {
		Paciente paciente = repository.getOne(id);
		if(paciente != null) {
			paciente.setDpi(nuevoPaciente.getDpi());
			paciente.setNombre(nuevoPaciente.getNombre());
			paciente.setApellido(nuevoPaciente.getApellido());
			paciente.setPass(nuevoPaciente.getPass());
			paciente.setGenero(nuevoPaciente.getGenero());
			paciente.setFecNacimiento(nuevoPaciente.getFecNacimiento());
			paciente.setDireccion(nuevoPaciente.getDireccion());
			paciente.setTipoSangre(nuevoPaciente.getTipoSangre());
			paciente.setNumSeguroMed(nuevoPaciente.getNumSeguroMed());
			return repository.save(paciente);
		} else {
			nuevoPaciente.setId(id);
			return repository.save(nuevoPaciente);
		}
	} 
	
}
