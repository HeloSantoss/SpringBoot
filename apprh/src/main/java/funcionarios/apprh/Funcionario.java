package funcionarios.apprh;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String email;
    private String disciplina;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getDisciplina(){
        return disciplina;
    }
    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }
}
