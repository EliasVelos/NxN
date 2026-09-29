package com.example.projetoN.exercicioN.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetoN.exercicioN.Entity.Aluno;
import com.example.projetoN.exercicioN.Service.AlunoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    //CRUD
    @GetMapping("/listarTodos")
    public String listarTodosAlunos(Model oModel) {

        oModel.addAttribute("listAlunos", alunoService.listarTodosAlunos());
        return "aluno/listarAluno";

    }

    @GetMapping("/formCadastrar")
    public String formCadastro(Model oModel) {

        oModel.addAttribute("aluno", new Aluno());
        return "aluno/cadastrarAluno";

    }
        
    @PostMapping("/salvar")
    public String salvarAluno(Aluno oAluno, Model oModel) {

        alunoService.salvarAluno(oAluno);
        return "redirect:/aluno/listarTodos";

    }

    @GetMapping("/excluir/{id}")
    public String excluirAluno(@PathVariable Long id) {

        alunoService.deletarAluno(id);
        return "redirect:/aluno/listarTodos";

    }

    @GetMapping("/editar/{id}")
    public String formAlterarAluno(@PathVariable long id, Model oModel) {

     Aluno alunoExistente = alunoService.buscarAlunoPorId(id);
     oModel.addAttribute("aluno", alunoExistente);
     return "aluno/cadastrarAluno";
    
    }

}