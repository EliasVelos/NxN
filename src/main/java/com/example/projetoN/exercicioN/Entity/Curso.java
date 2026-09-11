package com.example.projetoN.exercicioN.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso", nullable = false, unique = true)
    private Long id_curso;

    @Column(name = "nome_curso", nullable = false, length = 100)
    private String nome_curso;

    @Column(name = "carga_horaria", nullable = false)
    private Integer carga_horaria;

    @Column(name = "descricao_curso", nullable = false, length = 300)
    private String descricao_curso;

}