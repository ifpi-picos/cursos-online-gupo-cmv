package br.edu.ifpi.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import br.edu.ifpi.entidades.Curso;

public class CursoDao implements Dao<Curso> {

  private Connection conexao;

  public CursoDao(Connection conexao) {
    this.conexao = conexao;
  }

    @Override
    public int cadastrar(Curso curso) {
        String sql = "INSERT INTO CURSO (NOME_CURSO, STATUS, CARGAHORARIA, PROFESSOR_ID) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, curso.getNome());
            statement.setString(2, curso.getStatus());
            statement.setInt(3, curso.getCargaHoraria());
            statement.setInt(4, curso.getProfessor().getId());
            return statement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

        @Override
  public void exibir(){
    String sql = "SELECT * FROM CURSO";

    try {
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet resultSet = stm.executeQuery();

        System.out.println("\n----- Lista de cursos -----");
        while (resultSet.next()) {
            int idcurso = resultSet.getInt("ID_curso");
            String nome = resultSet.getString("NOME_CURSO");
            String status = resultSet.getString("STATUS");
            int cargaHoraria = resultSet.getInt("CARGAHORARIA");
            int idProfessor = resultSet.getInt("PROFESSOR_ID");

            System.out.println(idcurso + " | " + nome + " | " + status + " | " + cargaHoraria + " | " + idProfessor);
        }
    } catch (SQLException e) {
        System.err.format("Erro ao listar os professores. SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    }
  }
}
