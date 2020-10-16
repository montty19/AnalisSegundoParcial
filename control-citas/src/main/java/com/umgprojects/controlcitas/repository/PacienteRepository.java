package com.umgprojects.controlcitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umgprojects.controlcitas.entity.*;
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
