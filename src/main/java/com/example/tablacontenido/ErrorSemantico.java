package com.example.tablacontenido;

public class ErrorSemantico {
    private String mensaje;
    private int linea;

    public ErrorSemantico(String mensaje, int linea) {
        this.mensaje = mensaje;
        this.linea = linea;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getLinea() {
        return linea;
    }
}