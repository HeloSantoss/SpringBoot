package com.webapp.escola_completo_c.Controller.Repository;

import org.springframework.data.repository.CrudRepository;

public interface VerificaCadatroAdmRepository extends CrudRepository<VerificaCadatroAdmRepository, String> {
    
    VerificaCadatroAdmRepository findBycpf(String cpf);
}
