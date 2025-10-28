package com.MediSys.Sistema.de.marcacao.de.consultas.dto.paciente;

import com.MediSys.Sistema.de.marcacao.de.consultas.entities.Paciente;

import java.util.UUID;

public record DadosDetalhamentoPaciente(UUID id, String nome, String cpf, String email, String telefone) {

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone());
    }
}
