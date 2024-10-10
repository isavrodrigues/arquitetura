package main;

public class Pessoa {
    private String nome;
    private Conta conta;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String toString() {
        return nome;
    }
}
