package br.insper;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello World");

        // x = 10
        Integer x = 10;
        x = 500;

        x += 100;
        x++;
        ++x;
        x = x + 1;

        Float z = 100.0f;

        Double d = 100.0;

        Boolean b = true;

        String nome = "Abc";
        System.out.println("Nome;" + nome);

        if (x > 100) {
            System.out.println("Teste");
        } else if (x < 10)  {

        } else {

        }

        //for i in range(10);
        for (Integer i = 0; i < 10; i += 2) {
            System.out.println(i);
        }

        while (x == 10 && x == 20 || x == 30)  {

        }

        ArrayList<String> lista = new ArrayList<>();
        lista.add("5");
        lista.add("Teste");
        lista.add("false");

        //for i in lista:
        for (String valor : lista) {
            System.out.println(valor);
        }

        // p = Pessoa()
        Pessoa p = new Pessoa();
        p.nome = "Eduardo";
        p.anoNascimento = 1986;
        p.endereco = "Rua abc";

        p.imprimeIdade(2024);

        System.out.println(p);

        Pessoa p2 = new Pessoa();
        p2.nome = "Luiz";
        p2.anoNascimento = 2000;
        p2.endereco = "Rua xyz";

       // p2.calculaIdade(2024);


    }

}
