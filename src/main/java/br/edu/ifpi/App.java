package br.edu.ifpi;

import java.sql.SQLException;

import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.AutenticacaoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.dao.ProfessorDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.CursoAluno;
import br.edu.ifpi.entidades.Professor;

public class App {
    public static void main(String[] args) {
        try {
            AlunoDao alunoDao = new AlunoDao(Conexao.getConnection());
            CursoDao cursoDao = new CursoDao(Conexao.getConnection());
            ProfessorDao professorDao = new ProfessorDao(Conexao.getConnection());
            AutenticacaoDao autenticacaoDao = new AutenticacaoDao(Conexao.getConnection());

            Aluno alunoTeste = autenticacaoDao.autenticarAluno("pvsales@gmail.com");
            Curso cursoTeste = autenticacaoDao.autenticarCurso("Java");
            Professor professorTeste = autenticacaoDao.autenticarProfessor("vianajesiel@gmail.com");

            cursoTeste.cancelarMatricula(alunoTeste);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

