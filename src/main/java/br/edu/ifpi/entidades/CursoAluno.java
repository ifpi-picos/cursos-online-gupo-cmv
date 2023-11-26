package br.edu.ifpi.entidades;
import br.edu.ifpi.entidades.Curso;

import java.sql.Connection;

import br.edu.ifpi.entidades.Aluno;

public class CursoAluno {

    private Curso curso;
    private Aluno aluno;
    private float nota1;
   

    public CursoAluno(Curso curso, Aluno aluno) {
        this.curso = curso;
        this.aluno = aluno;
    }


    public CursoAluno(Connection connection) {
    }


    public Curso getCurso() {
        return curso;
    }


    public void setCurso(Curso curso) {
        this.curso = curso;
    }


    public Aluno getAluno() {
        return aluno;
    }


    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public float getNota1() {
        return nota1;
    }


    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public int getIdAluno() {
        return aluno.getid();
    }

    public int getIdCurso() {
        return curso.getId();
    }

    


}



