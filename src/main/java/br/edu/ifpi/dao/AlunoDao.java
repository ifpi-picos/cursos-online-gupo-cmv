package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

            System.out.println(row);
            return row;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }
    
    @Override
    public void exibir(){
        String sql = "SELECT * FROM ALUNO";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();

            System.out.println("\n----- Lista de alunos -----");
            while (resultSet.next()) {
                int idAluno = resultSet.getInt("ID_ALUNO");
                String nome = resultSet.getString("NOME_ALUNO");
                String email = resultSet.getString("EMAIL_ALUNO");
                int matricula = resultSet.getInt("MATRICULA_ALUNO");

                System.out.println(idAluno + " | " + nome + " | " + email + " | " + matricula);
            }
        } catch (SQLException e) {
            System.err.format("Erro ao listar os professores. SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
