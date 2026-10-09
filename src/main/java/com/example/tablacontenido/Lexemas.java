package com.example.tablacontenido;

public class Lexemas {

    // lo que reconoce el programa
    String[] reservadas = {"main", "for", "while", "if", "else", "string", "double", "int", "char", "float"};
    String[] tipos = {"int", "double", "float", "char", "string"};
    String simbolos = "(){}+*-/<>=;,";

    // busca en la lista de reservadas
    public boolean Reservada(String palabra) {
        for (int i = 0; i < reservadas.length; i++) {
            if (reservadas[i].equals(palabra)) {
                return true;
            }
        }
        return false;
    }

    public boolean Tipo(String palabra) {
        for (int i = 0; i < tipos.length; i++) {
            if (tipos[i].equals(palabra)) {
                return true;
            }
        }
        return false;
    }

    public boolean Simbolo(char c) {
        if (simbolos.indexOf(c) >= 0) {
            return true;
        }
        return false;
    }

    public boolean Letra(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

    public boolean Digito(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    // espacio
    public boolean Espacio(char c) {
        if (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
            return true;
        }
        return false;
    }

    public boolean esInicioIdentificador(char c) {
        if (Letra(c) || c == '_') {
            return true;
        }
        return false;
    }

    public boolean ParteIdentificador(char c) {
        if (Letra(c) || Digito(c) || c == '_') {
            return true;
        }
        return false;
    }
}