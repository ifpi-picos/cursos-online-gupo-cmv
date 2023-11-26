package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.CursoAluno;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusAluno;
import br.edu.ifpi.enums.StatusCurso;

public class AutenticacaoDao {
    private Connection conexao;

    public AutenticacaoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public Aluno autenticarAluno(String email) {
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

    public Professor autenticarProfessor(String email) {
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

    public Curso autenticarCurso(String nomeCurso) {
        String sql = "SELECT curso.id as curso_id, curso.nome as curso_nome, curso.carga_horaria, curso.status, " +
                "professor.id as professor_id, professor.nome as professor_nome, professor.email " +
                "FROM curso " +
                "JOIN professor ON curso.id_professor = professor.id " +
                "WHERE curso.nome = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setString(1, nomeCurso);
            try (ResultSet resultSet = stm.executeQuery()) {
                if (resultSet.next()) {
                    int idCurso = resultSet.getInt("curso_id");
                    String nome = resultSet.getString("curso_nome");
                    int cargaHoraria = resultSet.getInt("carga_horaria");
                    StatusCurso status = StatusCurso.valueOf(resultSet.getString("status"));
                    int idProfessor = resultSet.getInt("professor_id");
                    String nomeProfessor = resultSet.getString("professor_nome");
                    String emailProfessor = resultSet.getString("email");
                    Professor professor = new Professor(idProfessor, nomeProfessor, emailProfessor);

                    return new Curso(idCurso, nome, status, cargaHoraria, professor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
