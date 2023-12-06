package br.edu.ifpi;

import java.sql.SQLException;

import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.AutenticacaoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.dao.ProfessorDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.CursoAluno;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusCurso;

public class App {
    public static void main(String[] args) {
        try {
            AlunoDao alunoDao = new AlunoDao(Conexao.getConnection());
            CursoDao cursoDao = new CursoDao(Conexao.getConnection());
            ProfessorDao professorDao = new ProfessorDao(Conexao.getConnection());
            AutenticacaoDao autenticacaoDao = new AutenticacaoDao(Conexao.getConnection());
            CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(Conexao.getConnection());

            Aluno alunoTeste = autenticacaoDao.autenticarAluno("fernanda@gmail.com");
            Curso cursoTeste = autenticacaoDao.autenticarCurso("Java");
            Aluno alunoTeste2 = autenticacaoDao.autenticarAluno("carla@gmail.com");
            Aluno alunoTeste3 = autenticacaoDao.autenticarAluno("eduarda@gmail.com");
            Professor professorTeste = autenticacaoDao.autenticarProfessor("vianajesiel@gmail.com");
            CursoAluno cursoAluno = new CursoAluno(cursoTeste, alunoTeste2);

            //System.out.println("---------ALUNOS-----------");
            //alunoDao.consultar();
            //alunoDao.alterar(alunoTeste3);
            //alunoDao.cadastrar(alunoTeste3);
            //System.out.println("--------------------------");

            //System.out.println("-----------PROFESSORES-------------");
            //professorDao.alterar(professorTeste);
            //professorDao.cadastrar(professorTeste);
            //professorDao.cadastrarNotas(cursoAluno, null);
            //professorDao.consultar();
            //professorDao.cursosMinistrados(professorTeste);
            //professorDao.remover(professorTeste);
            //System.out.println("----------------------------------");

            //System.out.println("-------------CURSO------------");
            //cursoDao.consultarCursosAbertos();
            //cursoAlunoDao.cursosConcluido(alunoTeste2);
            //cursoAlunoDao.consultarBoletimAluno(alunoTeste2);
            //cursoAlunoDao.cursosConcluido(alunoTeste3);
            //cursoAlunoDao.cursosMatriculados(alunoTeste3);
            //cursoAlunoDao.remover(cursoAluno);
            //cursoAlunoDao.alterar(cursoAluno);
            //cursoAlunoDao.mediaALunos(cursoTeste);
            //cursoAlunoDao.porcentagemAprovados(cursoTeste);
            //cursoAlunoDao.quantidadeAlunosPorCurso(cursoTeste);
            //cursoAlunoDao.porcentagemReprovados(cursoTeste);
            //cursoAlunoDao.perfilAluno(alunoTeste3);
            //System.out.println("-----------------------------");

            //SE ESTIVER FALTANDO ALGUM PERDAO...



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
