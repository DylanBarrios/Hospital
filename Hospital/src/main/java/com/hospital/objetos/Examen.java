package com.hospital.objetos;

public class Examen {
    String codigo;
    String nombre;
    String TipoInforme;
    String  descripcion;
    double costo;
    boolean orden;

    public Examen(String codigo, String nombre, String TipoInforme, double costo, String descripcion, boolean orden) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.TipoInforme = TipoInforme;
        this.costo = costo;
        this.descripcion = descripcion;
        this.orden = orden;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoInforme() {
        return TipoInforme;
    }

    public double getCosto() {
        return costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isOrden() {
        return orden;
    }
    
    
}
