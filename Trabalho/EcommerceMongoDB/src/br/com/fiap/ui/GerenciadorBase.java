package br.com.fiap.ui;

import java.io.IOException;
import java.util.Scanner;

public abstract class GerenciadorBase {

    private Scanner reader;

    GerenciadorBase() {
        reader = new Scanner(System.in);
    }

    protected void LimparEEscrever(String texto) throws IOException {
        Runtime.getRuntime().exec("cls");
        System.out.println(texto);
    }

    protected String LerTexto(String texto) {
        System.out.println(texto);
        return reader.nextLine();
    }

    protected int LerInteiro(String texto) {
        System.out.println(texto);
        String teste = reader.nextLine();
        return Integer.parseInt(teste);
    }

    protected Integer LerInteiro(String texto, boolean validarNulidade) {
        System.out.println(texto);
        String valor = reader.nextLine();
        if(validarNulidade && valor == "") return null;

        return Integer.parseInt(valor);
    }

    protected Double LerDouble(String texto) {
        System.out.println(texto);
        return Double.parseDouble(reader.nextLine());
    }

    protected Double LerDouble(String texto, boolean validarNulidade) {
        System.out.println(texto);
        String valor =  reader.nextLine();
        if(validarNulidade && valor == "") return null;
        return Double.parseDouble(valor);
    }
}
