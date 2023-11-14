package br.edu.ifpi.dao;

public interface Dao<t> {
    
    public int cadastrar(t entidade);
    
    public void exibir();

    /*
    public int remover(t entidade); 

    public int alterar(t entidade);
    */
}
