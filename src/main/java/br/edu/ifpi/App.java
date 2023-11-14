package br.edu.ifpi;
import javax.swing.JOptionPane;
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
        String nome = JOptionPane.showInputDialog("Nome: ");
        String email = JOptionPane.showInputDialog("Email: ");
        

        Professor professor23 = new Professor("João", "joazao@gmail.com");  
        Curso curso = new Curso("Javaaaa", "Ativo", 40, professor23);

        cursoDao.cadastrar(curso);
           
    }
}
