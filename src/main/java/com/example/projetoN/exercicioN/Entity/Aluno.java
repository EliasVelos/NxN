package com.example.projetoN.exercicioN.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Aluno {
    
    public static Aluno alunoExistente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno", nullable = false, unique = true)
    private Long id_aluno;

    @Column(name = "nome_aluno", nullable = false, length = 100)
    private String nome_aluno;

    @Column(name = "cpf_aluno", nullable = false, length = 15)
    private String cpf_aluno;

    @Column(name = "email_aluno", nullable = false, length = 100)
    private String email_aluno;

}