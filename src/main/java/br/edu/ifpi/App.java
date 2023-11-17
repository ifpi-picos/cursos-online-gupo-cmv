package br.edu.ifpi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import br.edu.ifpi.enums.StatusAluno;
import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.dao.ProfessorDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;

public class App {
    public static void main(String[] args) {
       try{
           AlunoDao alunoDao = new AlunoDao(Conexao.getConnection());
           Aluno aluno = new Aluno("Matheus", "victor@gmai.com", StatusAluno.ATIVO);
           alunoDao.cadastrar(aluno);
           alunoDao.consultar();
           Aluno aluno2 = new Aluno("Carlos","viadinho@gmail.com", StatusAluno.INATIVO);
           alunoDao.cadastrar(aluno2);
           alunoDao.consultar();
           aluno2.setNome("Carlos");
           System.out.println(aluno2.getid());

       }catch(SQLException e){
           e.printStackTrace();
       }
       

        


           
    }
}
