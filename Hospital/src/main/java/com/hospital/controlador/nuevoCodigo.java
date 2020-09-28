package com.hospital.controlador;

public class nuevoCodigo {
    
    public static String getCodigo() {
        String codigo = "";
        int valorDado = 0;
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (int i = 0; i < 4; i++) {
            valorDado = (int) Math.floor(Math.random() * letras.length);
            codigo += letras[valorDado];
        }
        codigo += "-";
        for (int i = 0; i < 4; i++) {
            valorDado = (int) Math.floor(Math.random() * 9);
            codigo += valorDado;
        }

        return codigo;
    }
}
