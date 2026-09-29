package com.example.projetoN.exercicioN.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.projetoN.exercicioN.Entity.Aluno;
import com.example.projetoN.exercicioN.Repository.AlunoRepository;

@Service
public class AlunoService{

    //Mais seguro que o autowired
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    //CRUD
    //Listar todos os alunos
    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarAlunoPorId(Long id) {

        return alunoRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado com o ID: " + id));

    }

    public Aluno salvarAluno(Aluno oAluno) {
        return alunoRepository.save(oAluno);
    }

    public Aluno alterarAluno(Long id, Aluno objAlterarAluno) {

        Aluno alunoExistente = buscarAlunoPorId(id);

        alunoExistente.setNome_aluno(objAlterarAluno.getNome_aluno());
        alunoExistente.setCpf_aluno(objAlterarAluno.getCpf_aluno());
        alunoExistente.setEmail_aluno(objAlterarAluno.getEmail_aluno());

        return alunoRepository.save(alunoExistente);

    }

    public void deletarAluno(Long id) {

        Aluno alunoExistente = buscarAlunoPorId(id);
        alunoRepository.delete(alunoExistente);

    }
    
}