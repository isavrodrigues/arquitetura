package org.example;

import java.util.HashMap;

public class Time {
    public String nome;
    public Integer vitorias;
    public Integer derrotas;
    public Integer empates;

    public void verifica() {
        if (vitorias > derrotas) {
            System.out.println("Time tem mais vitorias");
        } else if (derrotas > vitorias) {
            System.out.println("Time tem mais derrotas");
        } else {
            System.out.println("Empate");
        }
    }


    public static void maisVitorias(HashMap<String, Time> times,
                                    String time1,
                                    String time2) {

        Time t1 = times.get(time1);
        Time t2 = times.get(time2);

        if (t1.vitorias > t2.vitorias) {
            System.out.println(String.format("%s tem mais vitorias", t1));
        } else if (t1.vitorias < t2.vitorias) {
            System.out.println(String.format("%s tem mais vitorias", t2));
        } else {
            System.out.println("Empate");
        }
    }


    @Override
    public String toString() {
        return nome;
    }
}
