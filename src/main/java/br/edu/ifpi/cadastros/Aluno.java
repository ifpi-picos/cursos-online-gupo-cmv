package br.edu.ifpi.cadastros;

public class Aluno {
    
    private String nome;
    private String email;

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getnome () {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
