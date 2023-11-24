package br.edu.ifpi.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.List;
import br.edu.ifpi.entidades.CursoAluno;


public class CursoAlunoDao implements Dao<CursoAluno> {
    private Connection conexao;
    
    public CursoAlunoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public int cadastrar(CursoAluno cursoAluno) {
String sql = "INSERT INTO CURSO_ALUNO (id_curso, id_aluno) VALUES (?,?)";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setInt(1, cursoAluno.getIdCurso());
            stm.setInt(2, cursoAluno.getIdAluno());

            int row = stm.executeUpdate();
            System.err.println(row);

            // rows affected
            System.out.println(row); // 1
            return row;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
       
    }

    @Override
    public List<CursoAluno> consultar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultar'");
    }

    @Override
    public int remover(CursoAluno ca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public int alterar(CursoAluno ca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }
}
