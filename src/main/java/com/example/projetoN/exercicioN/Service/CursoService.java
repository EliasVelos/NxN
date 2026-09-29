package com.example.projetoN.exercicioN.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.projetoN.exercicioN.Entity.Curso;
import com.example.projetoN.exercicioN.Repository.CursoRepository;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    //CRUD
    public List<Curso> listarTodosCursos() {
        return cursoRepository.findAll();
    }

    public Curso buscarCursoPorId(Long id) {

        return cursoRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado com o ID: " + id));

    }

    public Curso salvarCurso(Curso oCurso) {
        return cursoRepository.save(oCurso);
    }

    public Curso alterarCurso(Long id, Curso objAlterarCurso) {

        Curso cursoExistente = buscarCursoPorId(id);

        cursoExistente.setNome_curso(objAlterarCurso.getNome_curso());
        cursoExistente.setCarga_horaria(objAlterarCurso.getCarga_horaria());
        cursoExistente.setDescricao_curso(objAlterarCurso.getDescricao_curso());

        return cursoRepository.save(cursoExistente);

    }

    public void deletarCurso(Long id) {

        Curso cursoExistente = buscarCursoPorId(id);
        cursoRepository.delete(cursoExistente);

    }

}