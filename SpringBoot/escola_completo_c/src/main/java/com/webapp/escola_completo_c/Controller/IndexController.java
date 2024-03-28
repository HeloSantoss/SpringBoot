package com.webapp.escola_completo_c.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller

public class IndexController {
    @GetMapping("/home")
    public String acessoHomepage() {
        return ("index");
    }

    @GetMapping("/login-adm")
    public String acessoPageLoginAdm() {
        return "login/login-adm"; //escreve se duas vezes porque estão dentro da pagina. 
    }
    @GetMapping("/cadastro-adm")
    public String acessoPageCadastroAdm() {
        return "cadastro/cadastro-adm"; //escreve se duas vezes porque estão dentro da pagina. 
    }

}
