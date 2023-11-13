package br.edu.ifpi.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConexao() {
        try {
          Connection conexao = DriverManager.getConnection("jdbc:postgresql://sistacademico.c0h7tl22thbg.sa-east-1.rds.amazonaws.com:5432/sistacademico", "postgres", "AgoraFudeu-123");
          return conexao;
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return null;
    }

    public static Statement getStatement(Connection conexao) {
        try {
          Statement statement = (Statement) conexao.createStatement();
          return statement;
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return null;
    }
}
