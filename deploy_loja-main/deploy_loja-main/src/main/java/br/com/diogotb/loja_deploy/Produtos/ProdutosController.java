package br.com.diogotb.loja_deploy.Produtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProdutosController {
    
    @Autowired
    ProdutosRepository produtosRepository;

    @GetMapping("/loja")
    public List<Produto> list(){
        return (List<Produto>) this.produtosRepository.findAll();
    }

    @PostMapping("/loja")
    public Produto create(@RequestBody Produto produto){
        return produtosRepository.save(produto);
    }
    
}
