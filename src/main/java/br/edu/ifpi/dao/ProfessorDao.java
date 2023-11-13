package br.edu.ifpi.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import br.edu.ifpi.entidades.Professor;

public class ProfessorDao implements Dao<Professor> {

  private Connection conexao;

  public ProfessorDao(Connection conexao) {
    this.conexao = conexao;
  }

  @Override
  public int cadastrar(Professor professor) {
    String sql = "INSERT INTO PROFESSOR (NOME_PROFESSOR, EMAIL_PROFESSOR) VALUES (?,?)";

    try {
      PreparedStatement stm = conexao.prepareStatement(sql);

      stm.setString(1, professor.getNome());
      stm.setString(2, professor.getEmail());

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