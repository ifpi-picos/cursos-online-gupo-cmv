package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.ifpi.entidades.Aluno;

public class AlunoDao implements Dao<Aluno> {

    private Connection conexao;

    public AlunoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public int cadastrar(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, email, status) VALUES (?,?,?)";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setString(1, aluno.getNome());
            stm.setString(2, aluno.getEmail());
            stm.setString(3, aluno.getStatus());

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
    public List<Aluno> consultar() {

        String sql = "SELECT * FROM aluno order by id asc";
        ArrayList<Aluno> alunos = new ArrayList<>();

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();

            System.out.println("\n----- Lista de alunos -----");
            while (resultSet.next()) {
                int idAluno = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String status = resultSet.getString("status");

                Aluno aluno = new Aluno(idAluno, nome, email, null);
                alunos.add(aluno);
                System.out.println(aluno);
                System.out.println(idAluno + " | " + nome + " | " + email + " | " + status);

            }
        } catch (SQLException e) {
            System.err.format("Erro ao listar os alunos. SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return alunos;
    }

    @Override
    public int remover(Aluno aluno) {
        this.conexao = conexao;

        String sql = "DELETE FROM aluno WHERE id = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, aluno.getid());

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
    public int alterar(Aluno aluno) {
        this.conexao = conexao;

        String sql = "UPDATE aluno SET nome = ?, email = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, aluno.getNome());
            stm.setString(2, aluno.getEmail());
            stm.setString(3, aluno.getStatus());
            stm.setInt(4, aluno.getid());

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
}
