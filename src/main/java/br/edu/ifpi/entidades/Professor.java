package br.edu.ifpi.entidades;

import java.sql.SQLException;

import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.dao.ProfessorDao;

public class Professor {
    private int id = 1;
    private String nome;
    private String email;

    public Professor(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;

    }

    public Professor(String nome, String email) {
        this.nome = nome;
        this.email = email;

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

    public void setId(int id) {
        this.id = id;
    }

    public void exibirCursos(Professor professor) throws SQLException {
        ProfessorDao professorDao = new ProfessorDao(Conexao.getConnection());
        professorDao.cursosMinistrados(professor);
    }

    public void cadastrarNotas(CursoAluno cursoAluno, Double nota) throws SQLException {
        ProfessorDao professorDao = new ProfessorDao(Conexao.getConnection());
        professorDao.cadastrarNotas(cursoAluno, nota);
    }

    public void cadastrarCurso(Curso curso) throws SQLException {
        CursoDao cursoDao = new CursoDao(Conexao.getConnection());
        cursoDao.cadastrar(curso);
    }

}