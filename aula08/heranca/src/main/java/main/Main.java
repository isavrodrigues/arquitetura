package main;

import main.aluno.Aluno;
import main.professor.Professor;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.setNome("Nome");
        professor.setEndereco("Rua abc");
        professor.setDepartamento("Computacao");
        professor.setDataNascimento(LocalDateTime.now());


        System.out.println(professor);

        Aluno aluno = new Aluno();
        aluno.setNome("Aluno");
        aluno.setEndereco("Rua xyz");
        aluno.setSemestre(5);
        aluno.setCurso("Computação");

        apresenta(professor);

        List<Pessoa> pessoas = new ArrayList<>();
        x(pessoas);

        Map<String, Integer> map = new HashMap<>();

        Comprador c =  professor;

    }

    public static void x(List<Pessoa> ps) {
        ps.size();
    }

    public static void avalia(Avaliador avaliador, Aluno aluno) {
        avaliador.avaliar(aluno);
    }

    public static void apresenta(Pessoa pessoa) {
        pessoa.apresenta();
    }
}
