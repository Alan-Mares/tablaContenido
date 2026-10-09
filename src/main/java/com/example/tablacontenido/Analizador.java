package com.example.tablacontenido;

import java.io.*;
import java.util.*;

public class Analizador {

    Lexemas lexemas = new Lexemas();

    public ArrayList<Token> leerArchivo(File archivo) throws IOException {
        ArrayList<Token> tokens = new ArrayList<Token>();
        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        int numLinea = 1;
        String linea = lector.readLine();

        while (linea != null) {
            tokens.addAll(analizarLexico(linea, numLinea));
            numLinea++;
            linea = lector.readLine();
        }

        lector.close();
        return tokens;
    }

    public ArrayList<Token> analizarLexico(String linea, int numLinea) {
        ArrayList<Token> tokens = new ArrayList<Token>();
        int i = 0;

        while (i < linea.length()) {
            char c = linea.charAt(i);

            if (lexemas.Espacio(c)) {
                i++;
            } else if (lexemas.esInicioIdentificador(c)) {
                int ini = i;
                while (i < linea.length() && lexemas.ParteIdentificador(linea.charAt(i))) {
                    i++;
                }
                String lexema = linea.substring(ini, i);
                String tipo = "variable";
                if (lexemas.Reservada(lexema)) {
                    tipo = "palabra reservada";
                }
                tokens.add(new Token(lexema, tipo, numLinea, ini, i));
            } else if (lexemas.Digito(c)) {
                int ini = i;
                while (i < linea.length() && (lexemas.Digito(linea.charAt(i)) || linea.charAt(i) == '.')) {
                    i++;
                }
                tokens.add(new Token(linea.substring(ini, i), "numero", numLinea, ini, i));
            } else if (c == '\'' || c == '"') {
                int ini = i;
                char comilla = c;
                i++;
                while (i < linea.length() && linea.charAt(i) != comilla) {
                    i++;
                }
                String tipo = "error cadena sin cerrar";
                if (i < linea.length()) {
                    if (comilla == '"') {
                        tipo = "cadena string";
                    } else {
                        tipo = "cadena char";
                    }
                }
                tokens.add(new Token(linea.substring(ini, i), tipo, numLinea, ini, i));
            } else if (lexemas.Simbolo(c)) {
                tokens.add(new Token("" + c, "simbolo", numLinea, i, i + 1));
                i++;
            } else {
                tokens.add(new Token("" + c, "desconocido", numLinea, i, i + 1));
                i++;
            }
        }

        return tokens;
    }
}