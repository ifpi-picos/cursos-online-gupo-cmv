package br.edu.ifpi.entidades;

public class Administrador {
    private int id;
    private String nome;
    private String email;

    public Administrador(String nome, String email, int id) {
        this.nome = nome;
        this.email = email;
        this.id = id;
    }

    public Administrador(String nome, String email) {
        this.nome = nome;
        this.email = email;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
