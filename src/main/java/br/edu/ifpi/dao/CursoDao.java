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

        String[] colunas = { "nome", "carga_horaria", "status", "id_professor"};

        for (int i = 0; i < colunas.length; i++) {
            System.out.println("\nDeseja alterar o " + colunas[i] + " do curso? (s/n)");
            String valor = scanner.next();

            if (valor.equals("s")) {
                System.out.println("\nDigite o novo " + colunas[i] + " do curso:");
                valor = scanner.next();
                colunas[i] = valor;
            }
        }

        String sql = "UPDATE curso SET nome = COALESCE(?, nome), carga_horaria = COALESCE(?, carga_horaria), status = COALESCE(?, status), id_professor = COALESCE(?, id_professor) WHERE id = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, colunas[0].equals("nome") ? null : colunas[0]);
            stm.setString(2, colunas[1].equals("carga_horaria") ? null : colunas[1]);
            stm.setString(3, colunas[2].equals("status") ? null : colunas[2]);
            stm.setString(4, colunas[3].equals("id_professor") ? null : colunas[3]);
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
