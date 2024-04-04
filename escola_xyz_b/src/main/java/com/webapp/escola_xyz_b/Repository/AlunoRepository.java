package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.escola_xyz_b.Model.Aluno;
import java.util.List;


public interface AlunoRepository extends CrudRepository<Aluno,String>{

    Aluno findByCpf(String cpf);
} 
