package com.MediSys.Sistema.de.marcacao.de.consultas.entities;

import com.MediSys.Sistema.de.marcacao.de.consultas.dto.paciente.DadosAtualizarPaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String especialidade;
    private Boolean ativo = true;

    public void atualizarInformacoes(DadosAtualizarMedico dados) {
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
}
