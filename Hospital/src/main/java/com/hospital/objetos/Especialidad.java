package com.hospital.objetos;

public class Especialidad {
    
    private String Codigo;
    private String Nombre;
    private double Costo;

    public Especialidad(String Codigo, String Nombre, double Costo) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Costo = Costo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public double getCosto() {
        return Costo;
    }
   
}