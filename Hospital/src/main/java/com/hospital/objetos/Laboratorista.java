package com.hospital.objetos;

import java.util.Date;

public class Laboratorista {

    String codigo;
    String nombre;
    String dpi;
    String telefono;
    String registro;
    String correo;
    String password;
    String examen;
    Date inicioTrabajo;

    public Laboratorista(String codigo, String nombre, String dpi, String telefono, String registro, String correo, String password, String examen, Date inicioTrabajo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.dpi = dpi;
        this.telefono = telefono;
        this.registro = registro;
        this.correo = correo;
        this.password = password;
        this.examen = examen;
        this.inicioTrabajo = inicioTrabajo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDpi() {
        return dpi;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRegistro() {
        return registro;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public String getExamen() {
        return examen;
    }

    public Date getInicioTrabajo() {
        return inicioTrabajo;
    }

    
}
