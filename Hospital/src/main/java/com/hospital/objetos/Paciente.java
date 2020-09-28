package com.hospital.objetos;

import java.util.Date;

public class Paciente {
    private String Codigo;
    private String Nombre;
    private Date Nacimiento;
    private String DPI;
    private String Telefono;
    private Double Peso;
    private String Sangre;
    private String Correo;
    private String sexo;
    private String password;

    public Paciente(String Codigo, String Nombre, Date Nacimiento, String DPI, String Telefono, Double Peso, String Sangre, String Correo, String sexo, String password) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Nacimiento = Nacimiento;
        this.DPI = DPI;
        this.Telefono = Telefono;
        this.Peso = Peso;
        this.Sangre = Sangre;
        this.Correo = Correo;
        this.sexo = sexo;
        this.password = password;
    }

    public String getCodigo() {
        return Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public Date getNacimiento() {
        return Nacimiento;
    }

    public String getDPI() {
        return DPI;
    }

    public String getTelefono() {
        return Telefono;
    }

    public Double getPeso() {
        return Peso;
    }

    public String getSangre() {
        return Sangre;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getSexo() {
        return sexo;
    }

    public String getPassword() {
        return password;
    }
    
    
}
