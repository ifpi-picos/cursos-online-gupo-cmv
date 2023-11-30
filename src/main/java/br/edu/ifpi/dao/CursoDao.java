package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;

public class CursoDao implements Dao<Curso> {

    private Connection conexao;

    public CursoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public int cadastrar(Curso curso) {
        String sql = "INSERT INTO CURSO (NOME, STATUS, CARGA_HORARIA, ID_PROFESSOR) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, curso.getNome());
            statement.setString(2, curso.getStatusCurso());
            statement.setInt(3, curso.getCargaHoraria());
            statement.setInt(4, curso.getProfessor().getId());
            
            int row = statement.executeUpdate();

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
    public List<Curso> consultar() {
        String sql = "SELECT * FROM curso order by id asc";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();

            System.out.println("\n----- Lista de cursos -----");
            while (resultSet.next()) {
                int idcurso = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String status = resultSet.getString("status");
                int cargaHoraria = resultSet.getInt("CARGA_HORARIA");
                int idProfessor = resultSet.getInt("ID_PROFESSOR");

                System.out
                        .println(idcurso + " | " + nome + " | " + status + " | " + cargaHoraria + " | " + idProfessor);
            }
        } catch (SQLException e) {
            System.err.format("Erro ao listar os professores. SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    @Override
    public int remover(Curso curso) {
        this.conexao = conexao;

        String sql = "DELETE FROM curso WHERE id = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, curso.getId());

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
    public int alterar(Curso curso) {
        this.conexao = conexao;

        String sql = "UPDATE curso SET nome = ?, carga_horaria = ?, status = ?, id_professor = ? WHERE id = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, curso.getNome());
            stm.setInt(2, curso.getCargaHoraria());
            stm.setString(3, curso.getStatusCurso());
            stm.setInt(4, curso.getProfessor().getId());
            stm.setInt(5, curso.getId());

            int row = stm.executeUpdate();
            return row;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    public List<Curso> consultarCursosAbertos() {
        String sql = "SELECT * FROM curso WHERE status = 'ABERTO'";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();

            System.out.println("\n----- Lista de cursos abertos -----");
            while (resultSet.next()) {
                int idcurso = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String status = resultSet.getString("status");
                int cargaHoraria = resultSet.getInt("CARGA_HORARIA");
                int idProfessor = resultSet.getInt("ID_PROFESSOR");

                System.out
                        .println(idcurso + " | " + nome + " | " + status + " | " + cargaHoraria + " | " + idProfessor);
            }
        } catch (SQLException e) {
            System.err.format("Erro ao listar os professores. SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }

        public void matricularAlunonoCurso(Aluno aluno, Curso curso) {
        String sql = "INSERT INTO curso_aluno (id_curso, id_aluno) VALUES (?,?)";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setInt(1, curso.getId());
            stm.setInt(2, aluno.getid());

            int row = stm.executeUpdate();

            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();

        }

    }


}
