package com.MediSys.Sistema.de.marcacao.de.consultas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "consultas")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;
    private LocalDateTime dataHora;
    private Boolean ativo = true;
}
