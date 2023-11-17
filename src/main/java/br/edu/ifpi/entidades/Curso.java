package br.edu.ifpi.entidades;

import br.edu.ifpi.enums.StatusCurso;

public class Curso {
    private int id;
    private String nome;
    private StatusCurso status;
    private int cargaHoraria;
    private Professor professor;


    public Curso(String nome, StatusCurso status, int cargaHoraria, Professor professor) {
        this.nome = nome;
        this.status = status;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }
    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public StatusCurso getStatusCurso() {
        return status;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatusCurso(StatusCurso status) {
        this.status = status;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public void setId(int idCursoGerado) {
    }
    
 public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

}