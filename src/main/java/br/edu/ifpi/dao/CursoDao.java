package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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
            return statement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Curso> consultar() {
        String sql = "SELECT * FROM curso";

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
    public int remover() {
        CursoDao cursoDao = new CursoDao(conexao);
        cursoDao.consultar();

        System.out.println("\nDigite o ID do cruso que deseja remover:");
        Scanner scanner = new Scanner(System.in);
        int idCurso = scanner.nextInt();

        String sql = "DELETE FROM curso WHERE id = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, idCurso);

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
        CursoDao cursoDao = new CursoDao(conexao);
        cursoDao.consultar();

        System.out.println("\nDigite o ID do curso que deseja alterar:");
        Scanner scanner = new Scanner(System.in);
        int idCurso = scanner.nextInt();
        System.out.println("\nDigite o novo nome do curso:");
        String nome = scanner.next();
        System.out.println("\nDigite a nova carga horária do curso:");
        int cargaHoraria = scanner.nextInt();
        System.out.println("\nDigite o novo status do curso:");
        String status = scanner.next();
        System.out.println("\nDigite o novo ID do professor do curso:");
        int idProfessor = scanner.nextInt();

        String sql = "UPDATE curso SET nome = ?, status = ?, carga_horaria = ?, id_professor = ? WHERE id = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, nome);
            stm.setString(2, status);
            stm.setInt(3, cargaHoraria);
            stm.setInt(4, idProfessor);
            stm.setInt(5, idCurso);

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
