package com.MediSys.Sistema.de.marcacao.de.consultas.repository;

import com.MediSys.Sistema.de.marcacao.de.consultas.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {
}
