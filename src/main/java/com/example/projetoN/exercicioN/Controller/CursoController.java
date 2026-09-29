package com.example.projetoN.exercicioN.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetoN.exercicioN.Entity.Curso;
import com.example.projetoN.exercicioN.Service.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    //CRUD
    @GetMapping("/listarTodos")
    public String listarTodosCursos(Model oModel) {

        oModel.addAttribute("listCurso", cursoService.listarTodosCursos());
        return "curso/listarCurso";

    }

    @GetMapping("/formCadastrar")
    public String formCadastro(Model oModel) {

        oModel.addAttribute("curso", new Curso());
        return "curso/cadastrarCurso";

    }
        
    @PostMapping("/salvar")
    public String salvarCurso(Curso oCurso, Model oModel) {

        cursoService.salvarCurso(oCurso);
        return "redirect:/curso/listarTodos";

    }

    @GetMapping("/excluir/{id}")
    public String excluirCurso(@PathVariable Long id) {

        cursoService.deletarCurso(id);
        return "redirect:/curso/listarTodos";

    }

    @GetMapping("/editar/{id}")
    public String formAlterarCurso(@PathVariable long id, Model oModel) {

     Curso cursoExistente = cursoService.buscarCursoPorId(id);
     oModel.addAttribute("curso", cursoExistente);
     return "curso/cadastrarCurso";
    
    }
    
}