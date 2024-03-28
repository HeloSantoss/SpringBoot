package com.webapp.escola_completo_c.Controller.Repository;

import org.springframework.data.repository.CrudRepository;
import com.webapp.escola_completo_c.Model.Administrador;



public interface AdministradorRepository extends CrudRepository <Administrador,String>{
    
     Administrador findByCpf (String cpf);
     
}
