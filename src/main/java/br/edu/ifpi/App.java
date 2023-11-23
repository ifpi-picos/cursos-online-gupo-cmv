package br.edu.ifpi;

import java.sql.SQLException;
import br.edu.ifpi.enums.StatusAluno;
import br.edu.ifpi.enums.StatusCurso;
import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.AutenticacaoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.dao.ProfessorDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import java.util.Scanner;

/*
3. Criar tabelas de relacionamento entre as entidades e immprimí-las.
    * Cursos e professores;
    * Alunos, cursos e notas (+ média);
4. Sistema de autenticação e permissão de usuários.
*/

public class App {
    public static void main(String[] args) {
        try {
            AlunoDao alunoDao = new AlunoDao(Conexao.getConnection());
            CursoDao cursoDao = new CursoDao(Conexao.getConnection());
            ProfessorDao professorDao = new ProfessorDao(Conexao.getConnection());
            AutenticacaoDao autenticacaoDao = new AutenticacaoDao(Conexao.getConnection());


            System.out.println("\n");
            autenticacaoDao.autenticarProfessor("vianajesiel@gmail.com");
            System.out.println("\n");
            autenticacaoDao.autenticarProfessor("victorgay@gmail.com");
            System.out.println("\n");
            autenticacaoDao.autenticarAluno("sousamaykon@gmail.com");
            System.out.println("\n");
            autenticacaoDao.autenticarAluno("victorgay@gmail.com");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

