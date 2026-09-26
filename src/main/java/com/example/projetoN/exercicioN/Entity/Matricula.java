package com.example.projetoN.exercicioN.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Matricula {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula", nullable = false, unique = true)
    private Long id_matricula;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false) 
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @Column(name = "data_matricula", nullable = false)
    private String data_matricula;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "nota_final")
    private Double nota_final;
   
}
