package main.aluno;

import main.Avaliador;
import main.Comprador;
import main.Pessoa;
import main.professor.Professor;

public class Aluno extends Pessoa
        implements Avaliador<Professor>, Comprador {

    private Integer semestre;
    private String curso;

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public void avaliar(Professor professor) {

    }

    @Override
    public void compra() {

    }
}
