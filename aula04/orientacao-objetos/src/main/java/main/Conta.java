package main;

import java.time.LocalDateTime;

public class Conta {
    private String numeroConta;
    private Double saldo;

    public void deposito(Double valor) {
        System.out.println("Deposito efetuado");
        System.out.println(LocalDateTime.now());
        saldo += valor;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
