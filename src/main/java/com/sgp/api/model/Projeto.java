package com.sgp.api.model;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDate;

import com.sgp.api.constants.Prioridade;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Projeto {
    
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private LocalDate dataInicio;

    private LocalDate dataConclusao;

    private Prioridade prioridade;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status StatusTarefa;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario responsavel;

}
