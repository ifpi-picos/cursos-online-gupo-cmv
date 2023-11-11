package br.edu.ifpi.entidades;


public class Curso {

    private String nome;
    private String status;
    private int cargaHoraria;
    private Professor professor;

    public Curso(String nome, String status, int cargaHoraria, Professor professor) {
        this.nome = nome;
        this.status = status;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

}
