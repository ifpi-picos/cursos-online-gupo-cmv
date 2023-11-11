package br.edu.ifpi.dao;
import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.ProfessorDao;

public class CursoDao {

    private String nome;
    private String status;
    private int cargaHoraria;
    private ProfessorDao professor;

    public CursoDao(String nome, String status, int cargaHoraria, ProfessorDao professor) {
        this.nome = nome;
        this.status = status;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
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

    public ProfessorDao getProfessor() {
        return professor;
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

    public void setProfessor(ProfessorDao professor) {
        this.professor = professor;
    }
}
