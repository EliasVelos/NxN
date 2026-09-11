package com.example.projetoN.exercicioN.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoN.exercicioN.Entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository< Matricula, Long >{

    
}
