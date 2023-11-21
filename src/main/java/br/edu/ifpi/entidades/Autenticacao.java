package br.edu.ifpi.entidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Autenticacao {
    private List<Administrador> administradores;

    public Autenticacao() {
        this.administradores = new ArrayList<>();
    }

    public void cadastrarAdministrador(String nome, String email) {
        Administrador novoAdministrador = new Administrador(nome, email);
        administradores.add(novoAdministrador);
    }

    public boolean autenticarAdministrador(String Nome, String email) {
        for (Administrador administradores : administradores) {
            if (administradores.getNome().equals(Nome) && administradores.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean autenticarAdministrtador(String nome, String email) {
        return false;
    }
}
