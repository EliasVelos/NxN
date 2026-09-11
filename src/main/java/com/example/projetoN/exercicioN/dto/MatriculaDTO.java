package com.example.projetoN.exercicioN.dto;

import lombok.Data;

@Data
public class MatriculaDTO {
    
    private Long id_aluno;
    private Long id_curso;
    private String dataMatricula;
    private String status;
    private Double notaFinal;


}
