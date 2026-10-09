package com.example.tablacontenido;

public class Token {
    private String lexema;
    private String tipo;
    private int linea;
    private int inicio;
    private int fin;

    public Token(String lexema, String tipo, int linea, int inicio, int fin) {
        this.lexema = lexema;
        this.tipo = tipo;
        this.linea = linea;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getLexema() {
        return lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public int getLinea() {
        return linea;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFin() {
        return fin;
    }
}