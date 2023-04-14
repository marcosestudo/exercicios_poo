package poo.gerador_numeros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Gerador_numeros {

    public static void main(String[] args) {
        int n = 1000;

        gerarArquivoNumerosAleatorios(n);
        int[] histograma = calcularHistograma();

        for (int i = 0; i < histograma.length; i++) {
            System.out.println(i + ": " + histograma[i]);
        }
    }

    public static void gerarArquivoNumerosAleatorios(int n) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("numeros_aleatorios.txt"));
            Random rand = new Random();

            for (int i = 0; i < n; i++) {
                int numero = rand.nextInt(100);
                writer.write(String.valueOf(numero));
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] calcularHistograma() {
        int[] histograma = new int[100];

        try {
            BufferedReader reader = new BufferedReader(new FileReader("numeros_aleatorios.txt"));

            String linha;
            while ((linha = reader.readLine()) != null) {
                int numero = Integer.parseInt(linha);
                histograma[numero]++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return histograma;
    }
}
