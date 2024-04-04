package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.escola_xyz_b.Model.VerificaAluno;
import java.util.List;


public interface VerificaCadastroAluno extends CrudRepository<VerificaAluno,String> {
VerificaAluno findByCpf(String cpf);
    
} 
