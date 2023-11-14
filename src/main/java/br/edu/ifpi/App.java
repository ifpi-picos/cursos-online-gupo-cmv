package br.edu.ifpi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.ProfessorDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Professor;

public class App {
    public static void main(String[] args) {
        ProfessorDao professorDao = new ProfessorDao(Conexao.getConexao());
        AlunoDao alunoDao = new AlunoDao(Conexao.getConexao());
        
    }
}
