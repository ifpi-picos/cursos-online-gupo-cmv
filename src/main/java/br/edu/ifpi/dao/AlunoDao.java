package br.edu.ifpi.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpi.entidades.Aluno;

public class AlunoDao implements Dao<Aluno>{
    
    private Connection conexao;

    public AlunoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public int cadastrar(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome_aluno, email_aluno, matricula_aluno) VALUES (?,?,?)";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setString(1, aluno.getNome());
            stm.setString(2, aluno.getEmail());
            stm.setInt(3, aluno.getNumeroMatricula());

            int row = stm.executeUpdate();

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
    
}
