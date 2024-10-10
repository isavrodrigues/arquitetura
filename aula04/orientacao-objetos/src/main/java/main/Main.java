package main;

public class Main {

    public static void main(String[] args) {

        Pessoa p = new Pessoa();
        p.setNome("Eduardo");

        Conta c = new Conta();
        c.setSaldo(100.0);
        c.setNumeroConta("123");

        p.setConta(c);

        p.getConta().setSaldo(1000.0);

        System.out.println(p.getConta().getSaldo());
        System.out.println(c.getSaldo());

    }
}
