package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.webapp.escola_xyz_b.Model.Aluno;
import com.webapp.escola_xyz_b.Repository.AlunoRepository;
import com.webapp.escola_xyz_b.Repository.VerificaCadastroAluno;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    VerificaCadastroAluno verificaCadastroAluno;

    boolean acessoAluno = false;

    @PostMapping("cadastrar-aluno")
    public String cadastrarAlunoBD(Aluno aluno) {
        boolean verificaCpf = verificaCadastroAluno.existsById(aluno.getCpf());
        if (verificaCpf) {
            alunoRepository.save(aluno);
            System.out.println("Cadastro de aluno realizado com sucesso");
        } else {
            System.out.println("Falha ao cadastrar aluno");
        }
        return "/login/login-aluno";
    }

    @GetMapping("/interna-aluno")
    public String acessoPageInternaAluno() {
        String vaiPara = "";
        if (acessoAluno) {
            vaiPara = "interna/interna-aluno";
        } else {
            vaiPara = "login/login-aluno";
        }
        return vaiPara;
    }

    @PostMapping("acesso-aluno")
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
