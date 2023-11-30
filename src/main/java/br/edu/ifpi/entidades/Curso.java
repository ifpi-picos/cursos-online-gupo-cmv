package br.edu.ifpi.entidades;

import java.sql.SQLException;

import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
import br.edu.ifpi.dao.CursoDao;
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

    public void realizarMatriculaCurso(Aluno aluno) throws SQLException{
       CursoDao cursoDao = new CursoDao(Conexao.getConnection());
        cursoDao.matricularAlunonoCurso(aluno, this);
    }

    public void cancelarMatricula(Aluno aluno) throws SQLException {
        CursoAluno ca = new CursoAluno(this, aluno);
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.remover(ca);
    }

    public void exibirTurma(Curso curso) throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.consultarPorCurso(curso);
    }

    public void quantidadeAlunos(Curso curso) throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.quantidadeAlunosPorCurso(curso);
    }

    public void mediaGeral(Curso curso) throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.mediaALunos(curso);
    }

    public void porcentagemAprovados(Curso curso) throws SQLException {
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());
        cursoAlunoDao.porcentagemAprovados(curso);
    }
}