package br.edu.ifpi.entidades;
import br.edu.ifpi.enums.StatusAluno;

public class Aluno {
    private int idAluno;
    private String nome;
    private String email;
    private StatusAluno status;

    public Aluno(int idAluno ,String nome, String email, StatusAluno status) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.email = email;
        this.status = status;
       
    }


    public Aluno(String nome, String email, StatusAluno status) {
        this.nome = nome;
        this.email = email;
        this.status = status;
    }


    public int getid() {
        return idAluno;
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


    public String getStatus() {
        return this.status == StatusAluno.ATIVO? "ATIVO" : "INATIVO";    
    }

    public void setStatus(StatusAluno status) {
        this.status = status;
    }


    public void setId(int idAluno2) {
    }

    
}
