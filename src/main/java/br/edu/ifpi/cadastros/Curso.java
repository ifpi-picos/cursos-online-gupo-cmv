package br.edu.ifpi.cadastros;
import br.edu.ifpi.cadastros.Professor;
import br.edu.ifpi.cadastros.Aluno;

public class Curso {

    private String nome;
    private String status;
    private int cargaHoraria;
    private int notasAlunos;
    private String desempenho;
    private Professor professor;
    private Aluno aluno;

    public Curso(String nome, String status, int cargaHoraria, int notasAlunos, String desempenho, Professor professor, Aluno aluno) {
        this.nome = nome;
        this.status = status;
        this.cargaHoraria = cargaHoraria;
        this.notasAlunos = notasAlunos;
        this.desempenho = desempenho;
        this.professor = professor;
        this.aluno = aluno;
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

    public int getNotasAlunos() {
        return notasAlunos;
    }

    public String getDesempenho() {
        return desempenho;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Aluno getAluno() {
        return aluno;
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

    public void setNotasAlunos(int notasAlunos) {
        this.notasAlunos = notasAlunos;
    }

    



    
}
