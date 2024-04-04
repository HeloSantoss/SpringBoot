package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.escola_xyz_b.Model.VerificaProfessor;
import java.util.List;


public interface VerificaCadastroProfessor extends CrudRepository<VerificaProfessor,String> {
  VerificaProfessor findByCpf(String cpf);
    
} 
