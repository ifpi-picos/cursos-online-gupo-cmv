package br.edu.ifpi.dao;

import java.util.List;

public interface Dao<t> {
    
    public int cadastrar(t entidade);

    /*
    public List<t> exibir(t entidade);

    public int alterar(t entidade);

    public int remover(t entidade);
    */
}
