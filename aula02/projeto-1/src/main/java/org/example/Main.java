package org.example;

import org.example.csv.CsvReader;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CsvReader reader = new CsvReader("clubes.csv");
        reader.readCsv();

        ArrayList<PosicaoClube> data = reader.getData();

        Integer vitoriasBotafogo = 0;
        Integer vitoriasCorinthians2015 = 0;

        Integer vitorias = 0;
        Integer derrotas = 0;
        Integer empates = 0;

        Integer vitoriasPalmeiras = 0;
        Integer vitoriasCorinthians = 0;
        Integer totalGols = 0;
        for (PosicaoClube row : data) {

            if (row.clube.equals("Botafogo")) {
                vitoriasBotafogo += row.vitorias;
            }

            if (row.clube.equals("Palmeiras")) {
                vitoriasPalmeiras += row.vitorias;
            }


            if (row.clube.equals("Corinthians") ) {
                if (row.ano.equals(2015)) {
                    vitoriasCorinthians2015 += row.vitorias;
                }
                vitoriasCorinthians += row.vitorias;
            }

            if (row.ano.equals(2015)) {
                totalGols += row.pro;
            }

            vitorias += row.vitorias;
            derrotas += row.derrotas;
            empates += row.empates;

        }

        System.out.println("Vitorias Botafogo: " + vitoriasBotafogo);
        System.out.println("Vitorias corinthinas 2015: "  + vitoriasCorinthians2015);

        String texto  = String.format("Vitorias: %s Derrotas: %s Empates: %s", vitorias, derrotas, empates);
        System.out.println(texto);

        if (vitoriasPalmeiras > vitoriasCorinthians) {
            System.out.println("Palmeiras temm mais vitorias");
        } else if (vitoriasCorinthians > vitoriasPalmeiras){
            System.out.println("Corinthians tem mais vitorias");
        } else {
            System.out.println("Empate");
        }
        System.out.println("Total Gols 2015: " + totalGols);

        // 5 - Adicione na classe PosicaoClube os gols pró e contra
        // 6 - Adicione na classe CsvReader a leitura dos gols pró e contra, note que os dados estão em uma única célula, separados por um :
        // 7 - Some o total de gols feitos por todos os times em 2015

    }

}