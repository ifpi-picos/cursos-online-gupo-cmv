package br.edu.ifpi.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.List;
import br.edu.ifpi.entidades.CursoAluno;


public class CursoAlunoDao implements Dao<CursoAluno> {
    private Connection conexao;
    
    public CursoAlunoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public int cadastrar(CursoAluno ca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    @Override
    public List<CursoAluno> consultar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultar'");
    }

    @Override
    public int remover(CursoAluno ca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public int alterar(CursoAluno ca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }
}
