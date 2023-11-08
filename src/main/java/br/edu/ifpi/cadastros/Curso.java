package br.edu.ifpi.cadastros;
import br.edu.ifpi.cadastros.Professor;
import br.edu.ifpi.cadastros.Aluno;

public class Curso {
    
    private String nome;
    private String status;
    private int cargaHoraria;

    public Curso(String nome, String status, int cargaHoraria) {
        this.nome = nome;
        this.status = status;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
