package com.webapp.escola_completo_c.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


import com.webapp.escola_completo_c.Controller.Repository.AdministradorRepository;
import com.webapp.escola_completo_c.Controller.Repository.VerificaCadatroAdmRepository;
import com.webapp.escola_completo_c.Model.Administrador;
import org.springframework.web.bind.annotation.RequestBody;




    @Controller
    public class AdministradorController {
        @Autowired
        AdministradorRepository ar;

        @Autowired
        VerificaCadatroAdmRepository vcar;
    
        @PostMapping("cadastrar-adm")
        public String cadastrarAdmBD(Administrador adm) {
            boolean verificaCpf = vcar.existsById(adm.getCpf());
            if (verificaCpf) {
                ar.save(adm);
                System.out.println("Cadastro Realizado com Sucesso");
            }else{
                System.out.println("Falha ao Cadastrar");
            }

            return "login/login-adm";
        }
        @PostMapping("aceso-adm")
        public String postMethodName(@RequestBody String entity) {
            //Metodo para verificar acesso
            
            return entity;
        }
        
        
    }

