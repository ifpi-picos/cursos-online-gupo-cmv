package br.edu.ifpi.entidades;

public class Disciplina {
    private int id;
    private String nome;
    private int cargaHoraria;
    private Professor professor;

public Disciplina(String nome, int cargaHoraria, Professor professor) {
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
    this.professor = professor;
}

public Disciplina(int id, String nome, int cargaHoraria, Professor professor) {
    this.id = id;
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
    this.professor = professor;
}

public int getid() {
    return id;
}

public String getNome() {
    return nome;
}

public int getCargaHoraria() {
    return cargaHoraria;
}

public Professor getProfessor() {
    return professor;
}
public void setProfessor(Professor professor) {
    this.professor = professor;
}

}

