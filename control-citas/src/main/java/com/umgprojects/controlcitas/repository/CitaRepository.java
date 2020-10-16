package com.umgprojects.controlcitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umgprojects.controlcitas.entity.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer> {

}
