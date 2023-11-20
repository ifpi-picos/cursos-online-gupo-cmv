package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.edu.ifpi.entidades.Professor;

public class ProfessorDao implements Dao<Professor> {

  private Connection conexao;

  public ProfessorDao(Connection conexao) {
    this.conexao = conexao;
  }

  @Override
  public int cadastrar(Professor professor) {
    String sql = "INSERT INTO PROFESSOR (nome, email) VALUES (?,?)";

    try {
      PreparedStatement stm = conexao.prepareStatement(sql);

      stm.setString(1, professor.getNome());
      stm.setString(2, professor.getEmail());

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
  public List<Professor> consultar() {
    String sql = "SELECT * FROM professor";

    try {
      PreparedStatement stm = conexao.prepareStatement(sql);
      java.sql.ResultSet resultSet = stm.executeQuery();

      System.out.println("\n----- Lista de professores -----");
      while (resultSet.next()) {
        int idProfessor = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        String email = resultSet.getString("email");

        System.out.println(idProfessor + " | " + nome + " | " + email);
      }
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

    } catch (Exception e) {
      e.printStackTrace();

    }
    return null;
  }

  @Override
  public int remover() {
    ProfessorDao professorDao = new ProfessorDao(conexao);
    professorDao.consultar();

    System.out.println("\nDigite o ID do professor que deseja remover:");
    Scanner scanner = new Scanner(System.in);
    int idProfessor = scanner.nextInt();

    String sql = "DELETE FROM professor WHERE id = ?";

    try {
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, idProfessor);

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
  public int alterar() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'alterar'");
  }

}
