package br.edu.ifpi.dao;

public class Professor {
    private int id;
    private String nome;
    private String email;

    public Professor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Professor(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public int getid() {
        return id;
    }

    public String getnome() {
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
