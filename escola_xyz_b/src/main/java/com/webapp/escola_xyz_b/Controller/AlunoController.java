package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.escola_xyz_b.Model.Aluno;
import com.webapp.escola_xyz_b.Repository.AlunoRepository;

@Controller
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    boolean acessoAluno = false;

    @PostMapping("/cadastrar-aluno")
    public String cadastrarAlunoBD(Aluno aluno) {
        alunoRepository.save(aluno);
        System.out.println("Cadastro de aluno realizado com sucesso");
        return "redirect:/login/login-aluno";
    }

    @GetMapping("/interna-aluno")
    public String acessoPageInternaAluno() {
        return acessoAluno ? "interna/interna-aluno" : "login/login-aluno";
    }

    @PostMapping("/acesso-aluno")
    public String acessoAluno(@RequestParam String cpf, @RequestParam String senha) {
        try {
            boolean verificaCpf = alunoRepository.existsById(cpf);
            boolean verificaSenha = alunoRepository.findByCpf(cpf).getSenha().equals(senha);
            String url = "";
            if (verificaCpf && verificaSenha) {
                acessoAluno = true;
                url = "redirect:/interna-aluno";
            } else {
                url = "redirect:/login-aluno";
            }
            return url;
        } catch (Exception e) {
            return "redirect:/login-aluno";
        }
    }
}
