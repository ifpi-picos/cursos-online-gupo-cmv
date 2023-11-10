package br.edu.ifpi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://sistacademico.c0h7tl22thbg.sa-east-1.rds.amazonaws.com:5432/sistacademico", "postgres", "AgoraFudeu-123");

            if(conexao != null) {
                System.out.println("Conexão realizada com sucesso!");
            } else {
                System.out.println("Conexão não realizada!");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
