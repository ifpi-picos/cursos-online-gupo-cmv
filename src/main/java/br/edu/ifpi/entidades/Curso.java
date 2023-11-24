package br.edu.ifpi.entidades;

import java.sql.SQLException;

import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
import br.edu.ifpi.enums.StatusCurso;

public class Curso {
    private int id;
    private String nome;
    private StatusCurso status;
    private int cargaHoraria;
    private Professor professor;

    public Curso(int id, String nome, StatusCurso status, int cargaHoraria, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

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

    public String getStatusCurso() {
        return this.status == StatusCurso.ABERTO? "ABERTO" : "FECHADO";
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

    public void realizarMatricula(Aluno aluno) throws SQLException {
        CursoAluno ca = new CursoAluno(this, aluno);
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.cadastrar(ca);

    }

}