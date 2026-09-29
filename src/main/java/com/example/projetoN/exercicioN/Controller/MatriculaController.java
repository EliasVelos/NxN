package com.example.projetoN.exercicioN.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetoN.exercicioN.Service.AlunoService;
import com.example.projetoN.exercicioN.Service.CursoService;
import com.example.projetoN.exercicioN.Service.MatriculaService;
import com.example.projetoN.exercicioN.dto.MatriculaDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping ("/matricula")
public class MatriculaController {
    
    private final MatriculaService oMatriculaService;
    private final CursoService oCursoService;
    private final AlunoService oAlunoService;

    public MatriculaController(
        MatriculaService oMatriculaService,
        CursoService oCursoService,
        AlunoService oAlunoService) {

            this.oMatriculaService = oMatriculaService;
            this.oCursoService = oCursoService;
            this.oAlunoService = oAlunoService;

    }

    //CRUD
    @GetMapping("/listarTodos")
    public String listarMatricula(Model oModel) {

        oModel.addAttribute("listMatriculas", oMatriculaService.listarTodasMatriculas());
        return "matricula/listarMatricula";

    }
    
    @GetMapping("/formCadastrar")
    public String showFormCadastrarMatricula(Model oModel) {
        
        oModel.addAttribute("matriculaDTO", new MatriculaDTO());

        oModel.addAttribute("listAlunos", 
        oAlunoService.listarTodosAlunos());

        oModel.addAttribute("listCursos", 
        oCursoService.listarTodosCursos());

        return "matricula/cadastrarMatricula";

    }

    @PostMapping("/salvar")
    public String salvarMatricula(MatriculaDTO oMatriculaDTO) {
        
        if(oMatriculaDTO.getId_matricula() == null) {
            oMatriculaService.salvarMatricula(oMatriculaDTO);
        }
        else{
            oMatriculaService.alterarMatricula(oMatriculaDTO.getId_matricula(), oMatriculaDTO);
        }

        return "redirect:/matricula/listarTodos";
    }

    @GetMapping("/excluir/{id}")
    public String excluirMatricula(@PathVariable Long id) {

        oMatriculaService.deletarMatricula(id);
        return "redirect:/matricula/listarTodos";

    }
    
}