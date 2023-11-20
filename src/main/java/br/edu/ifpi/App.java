package br.edu.ifpi;

import java.sql.SQLException;
import br.edu.ifpi.enums.StatusAluno;
import br.edu.ifpi.enums.StatusCurso;
import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.dao.ProfessorDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
    try {
        AlunoDao alunoDao = new AlunoDao(Conexao.getConnection());
        CursoDao cursoDao = new CursoDao(Conexao.getConnection());
        ProfessorDao professorDao = new ProfessorDao(Conexao.getConnection());

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
