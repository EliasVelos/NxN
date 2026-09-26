package com.example.projetoN.exercicioN.dto;

import lombok.Data;

@Data
public class MatriculaDTO {
    
    private Long id_aluno;
    private Long id_curso;
    private Long id_matricula;
    private String data_matricula;
    private String status;
    private Double nota_final;


}
