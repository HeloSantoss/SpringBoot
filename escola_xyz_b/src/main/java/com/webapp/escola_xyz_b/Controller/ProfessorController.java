package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.escola_xyz_b.Model.Professor;
import com.webapp.escola_xyz_b.Repository.ProfessorRepository;

@Controller
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;

    boolean acessoProfessor = false;

    @PostMapping("/cadastrar-prof")
    public String cadastrarProfessorBD(Professor professor) {
        // Verificar se o CPF já existe antes de salvar
        if (!professorRepository.existsById(professor.getCpf())) {
            professorRepository.save(professor);
            System.out.println("Cadastro de Professor Realizado com Sucesso");
        } else {
            System.out.println("Falha ao cadastrar Professor: CPF já existe");
        }
        return "redirect:/login/login-prof"; // Redirecionar para a página de login
    }

    @GetMapping("/interna-prof")
    public String acessoPageInternaProfessor() {
        // Retornar a página interna se o acesso do professor estiver autorizado
        return acessoProfessor ? "interna/interna-prof" : "login/login-prof";
    }

    @PostMapping("/acesso-prof")
    public String acessoProfessor(@RequestParam String cpf, @RequestParam String senha) {
        // Verificar se o professor com o CPF fornecido existe
        try {
            if (professorRepository.existsById(cpf)) {
                Professor professor = professorRepository.findByCpf(cpf);
                // Verificar se a senha fornecida está correta
                if (professor.getSenha().equals(senha)) {
                    acessoProfessor = true; // Definir acesso do professor como verdadeiro
                    return "redirect:/interna-prof"; // Redirecionar para a página interna
                }
            }
        } catch (Exception e) {
            System.out.println("Erro durante o acesso do professor: " + e.getMessage());
        }
        // Redirecionar para a página de login em caso de falha
        return "redirect:/login-prof";
    }
}
