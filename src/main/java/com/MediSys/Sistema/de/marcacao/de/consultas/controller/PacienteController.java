package com.MediSys.Sistema.de.marcacao.de.consultas.controller;

import com.MediSys.Sistema.de.marcacao.de.consultas.dto.paciente.DadosAtualizarPaciente;
import com.MediSys.Sistema.de.marcacao.de.consultas.dto.paciente.DadosDetalhamentoPaciente;
import com.MediSys.Sistema.de.marcacao.de.consultas.dto.paciente.DadosSalvarPaciente;
import com.MediSys.Sistema.de.marcacao.de.consultas.entities.Paciente;
import com.MediSys.Sistema.de.marcacao.de.consultas.repository.PacienteRepository;
import com.MediSys.Sistema.de.marcacao.de.consultas.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.MediSys.Sistema.de.marcacao.de.consultas.service.MedicoService;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    PacienteRepository pacienteRepository;
    PacienteService pacienteService;

    public PacienteController(PacienteRepository pacienteRepository, PacienteService pacienteService) {
        this.pacienteService = pacienteService;
        this.pacienteRepository = pacienteRepository;
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<Paciente> salvarpaciente(@RequestBody DadosSalvarPaciente dados) {
        Paciente paciente = pacienteService.salvar(dados);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(paciente.getId())
                .toUri();
        return ResponseEntity.created(location).body(paciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoPaciente> buscarpaciente(@PathVariable UUID id) {
        Paciente paciente = pacienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DadosDetalhamentoPaciente>> listarPacientes() {
        var pacientes = pacienteService.listarPacientes()
                .stream()
                .map(DadosDetalhamentoPaciente::new)
                .toList();
        return ResponseEntity.ok(pacientes);
    }
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPaciente(@PathVariable  UUID id) {
       var paciente = pacienteRepository.getReferenceById(id);
       paciente.deletar();
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoPaciente> atualizarPaciente(@RequestBody DadosAtualizarPaciente dados,
                                                                       @PathVariable UUID id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
}
