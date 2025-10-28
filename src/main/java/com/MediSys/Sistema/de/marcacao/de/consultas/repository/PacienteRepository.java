package com.MediSys.Sistema.de.marcacao.de.consultas.repository;

import com.MediSys.Sistema.de.marcacao.de.consultas.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
    boolean findByCpf(String cpf);

    @Query("SELECT p FROM Paciente p WHERE p.ativo = true")
    List<Paciente> buscarTodosAtivos();
}
