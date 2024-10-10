package org.example;

import org.example.csv.CsvReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Main {

    public static void main(String[] args) {

        CsvReader reader = new CsvReader("clubes.csv");
        reader.readCsv();

        ArrayList<PosicaoClube> data = reader.getData();

        HashMap<String, Time> times = new HashMap<>();
        for (PosicaoClube row : data) {

            if (times.containsKey(row.clube)) {

                Time time = times.get(row.clube);
                time.vitorias += row.vitorias;
                time.derrotas += row.derrotas;
                time.empates += row.empates;

            } else {

                Time time = new Time();
                time.nome = row.clube;
                time.vitorias = row.vitorias;
                time.derrotas = row.derrotas;
                time.empates = row.empates;
                times.put(time.nome, time);

            }

        }

        Time.maisVitorias(times, "Palmeiras", "Corinthians");
        Time.maisVitorias(times, "Botafogo", "Flamengo");

        ArrayList<Time> listaTimes = new ArrayList<>(times.values());
        for (Time t : listaTimes) {


        }
    }



}