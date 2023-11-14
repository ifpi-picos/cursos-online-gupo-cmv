package br.edu.ifpi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.dao.ProfessorDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;

public class App {
    public static void main(String[] args) {
        ProfessorDao professorDao = new ProfessorDao(Conexao.getConexao());
        AlunoDao alunoDao = new AlunoDao(Conexao.getConexao());
        CursoDao cursoDao = new CursoDao(Conexao.getConexao());

        Professor professor23 = new Professor("João", "joazao@gmail.com");  
        Curso curso = new Curso("Javaaaa", "Trancado", 40, professor23);
        Aluno aluno = new Aluno("carl", 489384983, "carfd@gmail.com");
        Aluno aluno2 = new Aluno("carl", 489384983, "jdvjd@gmail.com");

        cursoDao.cadastrar(curso);
        cursoDao.exibir();
           
    }
}
