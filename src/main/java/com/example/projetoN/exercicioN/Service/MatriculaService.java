package com.example.projetoN.exercicioN.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projetoN.exercicioN.Entity.Matricula;
import com.example.projetoN.exercicioN.Repository.MatriculaRepository;
import com.example.projetoN.exercicioN.dto.MatriculaDTO;

@Service
public class MatriculaService {
    
    private final MatriculaRepository matriculaRepository;
    private final AlunoService alunoService;
    private final CursoService cursoService;

    public MatriculaService(MatriculaRepository matriculaRepository, AlunoService alunoService, CursoService cursoService) {
        this.matriculaRepository = matriculaRepository;
        this.alunoService = alunoService;
        this.cursoService = cursoService;
    }

    public List<Matricula> listarTodasMatriculas() {
        return matriculaRepository.findAll();
    }

    public Matricula salvarMatricula(MatriculaDTO oMatriculaDTO) {
        
        Matricula novaMatricula = new Matricula();

        novaMatricula.setAluno(
            alunoService.buscarAlunoPorId(oMatriculaDTO.getId_aluno()));
        novaMatricula.setCurso(
            cursoService.buscarCursoPorId(oMatriculaDTO.getId_curso()));

        novaMatricula.setData_matricula(oMatriculaDTO.getData_matricula());
        novaMatricula.setStatus(oMatriculaDTO.getStatus());
        novaMatricula.setNota_final(oMatriculaDTO.getNota_final());

        return matriculaRepository.save(novaMatricula);

    }

    public Matricula buscarMatriculaPorId(Long id) {

        return matriculaRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException(
                "Matrícula não encontrada com o ID: " + id));

    }

    public Matricula editarMatricula(Long id, MatriculaDTO oMatriculaDTO) {

        Matricula matriculaExistente = new Matricula();

        matriculaExistente.setAluno(
            alunoService.buscarAlunoPorId(oMatriculaDTO.getId_aluno()));
        matriculaExistente.setCurso(
            cursoService.buscarCursoPorId(oMatriculaDTO.getId_curso()));

        matriculaExistente.setData_matricula(oMatriculaDTO.getData_matricula());
        matriculaExistente.setStatus(oMatriculaDTO.getStatus());
        matriculaExistente.setNota_final(oMatriculaDTO.getNota_final());

        return matriculaRepository.save(matriculaExistente);

    }

    public void excluirMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }

}