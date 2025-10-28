package com.MediSys.Sistema.de.marcacao.de.consultas.repository;

import com.MediSys.Sistema.de.marcacao.de.consultas.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {

}
