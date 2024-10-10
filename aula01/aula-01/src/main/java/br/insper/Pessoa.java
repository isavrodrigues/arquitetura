package br.insper;

public class Pessoa {
    String nome;
    String endereco;
    Integer anoNascimento;

    public void imprimeIdade(Integer  anoAtual) {
        System.out.println(calculaIdade(anoAtual));
    }

    private Integer calculaIdade(Integer anoAtual) {
        return anoAtual - anoNascimento;
    }


}
