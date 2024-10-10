package org.example.csv;

import org.example.PosicaoClube;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CsvReader {
    private String filePath;
    private ArrayList<PosicaoClube> data;

    public CsvReader(String filePath) {
        this.filePath = filePath;
        this.data = new ArrayList<>();
    }

    public void readCsv() {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                br.readLine();
                while ((line = br.readLine()) != null) {

                    // 2017,18,America-MG,10,10,18,30:47
                    // [0] = 2017
                    // [1] = 18
                    // [2] = America-MG

                    // [6] = 30:47
                    String[] values = line.split(",");

                    PosicaoClube posicaoClube = new PosicaoClube();
                    posicaoClube.ano = Integer.parseInt(values[0]);
                    posicaoClube.posicao = Integer.parseInt(values[1]);
                    posicaoClube.clube = values[2];
                    posicaoClube.vitorias = Integer.parseInt(values[3]);
                    posicaoClube.derrotas = Integer.parseInt(values[4]);
                    posicaoClube.empates = Integer.parseInt(values[5]);

                    String[] gols = values[6].split(":");
                    posicaoClube.pro = Integer.parseInt(gols[0]);
                    posicaoClube.contra = Integer.parseInt(gols[1]);

                    data.add(posicaoClube);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PosicaoClube> getData() {
        return new ArrayList<>(data);
    }

    public PosicaoClube getRow(int index) {
        if (index >= 0 && index < data.size()) {
            return data.get(index);
        }
        return null;
    }

}
