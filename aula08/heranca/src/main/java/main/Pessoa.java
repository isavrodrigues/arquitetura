package main;

import java.time.LocalDateTime;

abstract public class Pessoa {
    private String nome;
    private LocalDateTime dataNascimento;
    private String endereco;
    private String cpf;

    public void apresenta() {
        System.out.println("Olá, meu nome é "
                + nome + " e moro em " + endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
