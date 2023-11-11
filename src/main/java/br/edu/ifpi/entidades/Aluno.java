package br.edu.ifpi.entidades;

public class Aluno {
    private int id;
    private String nome;
    private int numeroMatricula;
    private String email;

    public Aluno(String nome, int numeroMatricula, String email) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
        this.email = email;
    }

    public int getid() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
