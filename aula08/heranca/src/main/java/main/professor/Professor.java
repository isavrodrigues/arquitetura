package main.professor;

import main.aluno.Aluno;
import main.Avaliador;
import main.Comprador;
import main.Pessoa;

public class Professor extends Pessoa
        implements Avaliador<Aluno>, Comprador {

    private Double salario;
    private String departamento;

    @Override
    public void compra() {

    }

    @Override
    public void avaliar(Aluno aluno) {
        System.out.println("O aluno " + aluno.getNome() +
                " tirou nota 10");
    }

    @Override
    public void apresenta() {
        super.apresenta();
        System.out.println(" e estou no " + departamento);
    }

    @Override
    public String toString() {
        return String.format("Nome: %s", getNome());
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
