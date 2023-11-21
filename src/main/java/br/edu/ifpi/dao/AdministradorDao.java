package br.edu.ifpi.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.List;
import br.edu.ifpi.entidades.Administrador;
import br.edu.ifpi.entidades.Aluno;

public class AdministradorDao implements Dao<Administrador> {
    private Connection conexao;

    public AdministradorDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public int cadastrar(Administrador administrador) {
        String sql = "INSERT INTO administrador (nome, email) VALUES (?,?)";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setString(1, administrador.getNome());
            stm.setString(2, administrador.getEmail());
        
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
    public List<Administrador> consultar() {
        
        String sql = "SELECT * FROM administrador order by id asc";
        ArrayList<Administrador> administradores = new ArrayList<>();

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();

            System.out.println("\n----- Lista de Administradores -----");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");

                Administrador administrador = new Administrador( id, nome, email);
                administradores.add(administrador);
                System.out.println(administrador);

                System.out.println(id + " | " + nome + " | " + email);
            }
        } catch (SQLException e) {
            System.err.format("Erro ao listar os administradores. SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return administradores;

    }

    @Override
    public int remover() {

        System.out.println("\nDigite o ID do administrador que deseja remover:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        String sql = "DELETE FROM administrador WHERE id = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);

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
        AdministradorDao administradorDao = new AdministradorDao(conexao);
        administradorDao.consultar();

        System.out.println("\nDigite o ID do Administrador voce que deseja alterar:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        String[] colunas = { "nome", "email" };

        for (int i = 0; i < colunas.length; i++) {
            System.out.println("\nDeseja alterar o " + colunas[i] + " do administrador (s/n)");
            String valor = scanner.next();

            if (valor.equals("s")) {
                System.out.println("\nDigite o novo " + colunas[i] + " do administrador:");
                valor = scanner.next();
                colunas[i] = valor;
            }
        }

        String sql = "UPDATE administrador SET nome = COALESCE(?, nome), email = COALESCE(?, email) WHERE id = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, colunas[0].equals("nome") ? null : colunas[0]);
            stm.setString(2, colunas[1].equals("email") ? null : colunas[1]);
            stm.setInt(3, id);

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
