package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:postgresql://sistacademico.c0h7tl22thbg.sa-east-1.rds.amazonaws.com:5432/sistacademico";  
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "AgoraFudeu-123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}