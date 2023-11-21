package br.edu.ifpi;

import java.sql.SQLException;
import br.edu.ifpi.enums.StatusAluno;
import br.edu.ifpi.enums.StatusCurso;
import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.dao.ProfessorDao;
import br.edu.ifpi.entidades.Administrador;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.dao.AdministradorDao;
import java.util.Scanner;

/*
1. Implementar uma dinâmica de não alteração de informações no banco de dados caso o ususário não queira alterá-las.
2. Implementar um for que percorra as colunas de uma tabela para evitar repetição de códigos no método de alteração.
3. Criar tabelas de relacionamento entre as entidades e immprimí-las.
    * Cursos e professores;
    * Alunos, cursos e notas (+ média);
4. Sistema de autenticação e permissão de usuários.
*/

public class App {
    public static void main(String[] args) {
        try {

        
            /* 
            AdministradorDao administradorDao = new AdministradorDao(Conexao.getConnection());
            Administrador administrador = new Administrador("ExemploAdministrador", "victor@gmail.com");
            administradorDao.cadastrar(administrador);
            administradorDao.consultar();
            administradorDao.remover();
            administradorDao.alterar();
            */
            




            /*AlunoDao alunoDao = new AlunoDao(Conexao.getConnection());
            CursoDao cursoDao = new CursoDao(Conexao.getConnection());
            ProfessorDao professorDao = new ProfessorDao(Conexao.getConnection());

            Aluno aluno = new Aluno("ExemploAluno", "alunoexemplo@gmail.com", StatusAluno.ATIVO);
            Professor professor = new Professor("ExemploProfessor", "professorexemplo@gmail.com");
            Curso curso = new Curso("ExemploCurso", StatusCurso.ABERTO, 100, professor);

            // alunoDao.cadastrar(aluno);
            // professorDao.cadastrar(professor);
            // cursoDao.cadastrar(curso);

            cursoDao.alterar();
            */
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

