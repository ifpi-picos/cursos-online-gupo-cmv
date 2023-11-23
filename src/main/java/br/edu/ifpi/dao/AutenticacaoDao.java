package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusAluno;

public class AutenticacaoDao {
    private Connection conexao;

    public AutenticacaoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public Aluno autenticarAluno(String email){
        String sql = "SELECT id, nome, email, status FROM aluno WHERE email = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                int idAluno = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String emailAluno = resultSet.getString("email");
                StatusAluno status = StatusAluno.valueOf(resultSet.getString("status"));
                
                System.out.println("Aluno autenticado com sucesso!");
                return new Aluno(idAluno, nome, emailAluno, status);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();

        }

        System.out.println("Aluno não encontrado!");
        return null;
    }

    public Professor autenticarProfessor(String email){
        String sql = "SELECT id, nome, email FROM professor WHERE email = ?";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                int idProfessor = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String emailProfessor = resultSet.getString("email");

                System.out.println("Professor autenticado com sucesso!");
                return new Professor(idProfessor, nome, emailProfessor);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();

        }

        System.out.println("Professor não encontrado!");
        return null;
    }
}
