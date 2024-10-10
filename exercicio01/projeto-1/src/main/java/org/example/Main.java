package org.example;

import org.example.csv.CsvReader;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CsvReader reader = new CsvReader("nba.csv");
        reader.readCsv();

        ArrayList<JogadorTemporada> data = reader.getData();

        for (JogadorTemporada row : data) {
            System.out.println(row.jogador);
            System.out.println(row.pais);
            System.out.println(row.pontos);
            System.out.println(row.temporada);
        }

        // 1 - Jogador com a melhor média de pontos por temporada
        // 2 - Jogador com a melhor média de assistências por temporada
        // 3 - Jogador com a melhor média de rebotes
        // 4 - Jogador mais novo entre todas as temporadas
        // 5 - Jogador mais velho entre todas temporadas
        // 6 - Quantas vezes cada jogador mudou de time


    }

}