package br.edu.ifpi.entidades;
import java.util.ArrayList;
import java.util.List;

public class Professor {
    private int id;
    private String nome;
    private String email;
    private List<Curso> cursosMinistrados;

    public Professor(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.cursosMinistrados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Curso> getCursosMinistrados() {
        return cursosMinistrados;
    }

    public void setCursosMinistrados(List<Curso> cursosMinistrados) {
        this.cursosMinistrados = cursosMinistrados;
    }


}
