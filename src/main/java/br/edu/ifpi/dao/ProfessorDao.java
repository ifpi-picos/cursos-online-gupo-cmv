package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.edu.ifpi.entidades.CursoAluno;
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
    String sql = "SELECT * FROM professor order by id asc";

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
  public int remover(Professor professor) {
    this.conexao = conexao;

    String sql = "DELETE FROM professor WHERE id = ?";

    try {
      PreparedStatement stm = conexao.prepareStatement(sql);
      stm.setInt(1, professor.getId());

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
  public int alterar (Professor professor) {
    this.conexao = conexao;

    String sql = "UPDATE professor SET nome = ?, email = ? WHERE id = ?";
    try {
      PreparedStatement stm = conexao.prepareStatement(sql);
      
      stm.setString(1, professor.getNome());
      stm.setString(2, professor.getEmail());
      stm.setInt(3, professor.getId());

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

  public int cadastrarNotas(CursoAluno cursoAluno) {
  String sql = "UPDATE aluno_curso SET nota1 = ? WHERE id_aluno = ? AND id_curso = ?";

  try {
    PreparedStatement stm = conexao.prepareStatement(sql);

    stm.setDouble(1, cursoAluno.getNota1());
    stm.setInt(2, cursoAluno.getIdAluno());
    stm.setInt(3, cursoAluno.getIdCurso());

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
