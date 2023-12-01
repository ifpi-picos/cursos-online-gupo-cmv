package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.ifpi.entidades.Curso;
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
  public int alterar(Professor professor) {
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

  public int cadastrarNotas(CursoAluno cursoAluno, Double nota) {
    String sql = "UPDATE curso_aluno SET nota = ?, status_matricula = 'CONCLUIDO'  WHERE id_aluno = ? AND id_curso = ?";

    try {
      PreparedStatement stm = conexao.prepareStatement(sql);

      stm.setDouble(1, nota);
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

  public List<Curso> cursosMinistrados(Professor professor) {
    String sql = "SELECT curso.nome as nome, curso.carga_horaria as carga_horaria, curso.status as status, curso.id as id " +
        "FROM curso " +
        "WHERE curso.id_professor = ?";

    List<Curso> cursos = new ArrayList<>();

    try {
      PreparedStatement stm = conexao.prepareStatement(sql);
      stm.setInt(1, professor.getId());

      java.sql.ResultSet resultSet = stm.executeQuery();

      System.out.println("\n----- Lista de cursos ministrados -----");
      while (resultSet.next()) {
        String nome = resultSet.getString("nome");
        int cargaHoraria = resultSet.getInt("carga_horaria");
        String status = resultSet.getString("status");

        System.out.println(nome + " | " + cargaHoraria + " | " + status);
      }
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

    } catch (Exception e) {
      e.printStackTrace();

    }

    return cursos;
  }

  public void vizualizarCursosProfessores(Professor professor) {
    String sql = "SELECT curso.nome as curso_nome, professor.nome as professor_nome " +
        "FROM curso " +
        "INNER JOIN professor ON curso.id_professor = professor.id " +
        "WHERE professor.nome = ?"; 

    try {
      PreparedStatement stm = conexao.prepareStatement(sql);
      stm.setString(1, professor.getNome());

      java.sql.ResultSet resultSet = stm.executeQuery();

      System.out.println("\n----- Lista de Professores e seus Cursos -----");
      while (resultSet.next()) {
        String nomeCurso = resultSet.getString("curso_nome");
        String nomeProfessor = resultSet.getString("professor_nome");

        System.out.println(nomeCurso + " | " + nomeProfessor);
      }
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

    } catch (Exception e) {
      e.printStackTrace();

    }
  }

}
