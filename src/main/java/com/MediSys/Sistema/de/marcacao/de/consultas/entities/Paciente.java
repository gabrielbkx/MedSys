package com.MediSys.Sistema.de.marcacao.de.consultas.entities;

import com.MediSys.Sistema.de.marcacao.de.consultas.dto.paciente.DadosAtualizarPaciente;
import com.MediSys.Sistema.de.marcacao.de.consultas.dto.paciente.DadosSalvarPaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Boolean ativo = true;

    public void atualizarInformacoes(DadosAtualizarPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }

    }
    public void deletar() {
        this.ativo = false;
    }

    public Paciente(DadosSalvarPaciente dados){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }
}
