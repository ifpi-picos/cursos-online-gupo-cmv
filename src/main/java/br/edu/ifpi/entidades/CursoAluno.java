package br.edu.ifpi.entidades;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Aluno;

public class CursoAluno {

    private Curso curso;
    private Aluno aluno;


    public CursoAluno(Curso curso, Aluno aluno) {
        this.curso = curso;
        this.aluno = aluno;
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

}



