package com.MediSys.Sistema.de.marcacao.de.consultas.service;

import com.MediSys.Sistema.de.marcacao.de.consultas.dto.paciente.DadosSalvarPaciente;
import com.MediSys.Sistema.de.marcacao.de.consultas.entities.Paciente;
import com.MediSys.Sistema.de.marcacao.de.consultas.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente salvar(DadosSalvarPaciente dados) {

        var pacienteExistente = pacienteRepository.findByCpf(dados.cpf());

        if (pacienteExistente) {
            throw new IllegalArgumentException("Paciente com CPF " + dados.cpf() + " já existe.");
        }

        Paciente paciente = new Paciente(dados);
        pacienteRepository.save(paciente);
        return paciente;
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.buscarTodosAtivos();
    }
}
