package com.example.projetoN.exercicioN.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetoN.exercicioN.Service.AlunoService;
import com.example.projetoN.exercicioN.Service.CursoService;
import com.example.projetoN.exercicioN.Service.MatriculaService;
import com.example.projetoN.exercicioN.dto.MatriculaDTO;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping ("/matriculaCTR")
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

    @GetMapping("/listarMatriculas")
    public String listarMatricula(Model oModel) {

        oModel.addAttribute("matriculas", 
        oMatriculaService.listarTodasMatriculas());
        return "listarMatricula";

    }
    
    @GetMapping("/formCadastrarMatricula")
    public String showFormCadastrarMatricula(Model oModel) {
        
        oModel.addAttribute("matriculaDTO", new MatriculaDTO());

        oModel.addAttribute("listAlunos", 
        oAlunoService.listarTodosAlunos());

        oModel.addAttribute("listCursos", 
        oCursoService.listarTodosCursos());

        return "cadastrarMatricula";

    }
    

}
