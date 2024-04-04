package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.escola_xyz_b.Model.Professor;
import java.util.List;


public interface ProfessorRepository extends CrudRepository<Professor,String> {
  Professor findByCpf(String cpf);
    
} 
