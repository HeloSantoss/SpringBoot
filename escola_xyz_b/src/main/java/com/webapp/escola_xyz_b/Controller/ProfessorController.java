package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.webapp.escola_xyz_b.Model.Professor;
import com.webapp.escola_xyz_b.Repository.ProfessorRepository;
import com.webapp.escola_xyz_b.Repository.VerificaCadastroProfessor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfessorController {

    @Autowired
    ProfessorRepository ar;

    @Autowired
    VerificaCadastroProfessor vcar;

    boolean acessoProfessor = false;

    @PostMapping("cadastrar-prof")
    public String cadastrarProfessorBD(Professor prof) {
        boolean verificaCpf = vcar.existsById(prof.getCpf());
        if (verificaCpf) {
            ar.save(prof);
            System.out.println("Cadastro de Professor Realizado com Sucesso");
        } else {
            System.out.println("Falha ao Cadastrar Professor");

        }
        return "/login/login-prof";
    }

    @GetMapping("/interna-prof")
    public String acessoPageInternaProfessor() {
        String vaiPara = "";
        if (acessoProfessor) {
            vaiPara = "interna/interna-prof";
        } else {
            vaiPara = "login/login-prof";
        }
        return vaiPara;
    }

    @PostMapping("acesso-prof")
    public String acessoProfessor(@RequestParam String cpf,
            @RequestParam String senha) {
        try {
            boolean verificaCpf = ar.existsById(cpf);
            boolean verificaSenha = ar.findByCpf(cpf).getSenha().equals(senha);
            String url = "";
            if (verificaCpf && verificaSenha) {
                acessoProfessor = true;
                url = "redirect:/interna-prof";
            } else {
                url = "redirect:/login-prof";
            }
            return url;
        } catch (Exception e) {
            return "redirect:/login-prof";
        }

    }
}
