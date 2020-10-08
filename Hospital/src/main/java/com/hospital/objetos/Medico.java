package com.hospital.objetos;

import java.util.Date;

public class Medico {
    private String Codigo;
    private String Nombre;
    private String DPI;
    private String Telefono;
    private String Colegiado;
    private String Correo;
    private Date InicioTrabajo;
    private String Password;
    private String especialidad;
    private String horaEntrada;
    private String horaSalida;
    
    public Medico(String Nombre, String DPI, String Codigo, String Password, String Telefono, String Colegiado, String Correo, String horaEntrada, String horaSalida, String especialidad, Date InicioTrabajo) {
        this.Nombre = Nombre;
        this.DPI = DPI;
        this.Codigo = Codigo;
        this.Password = Password;
        this.Telefono = Telefono;
        this.Colegiado = Colegiado;
        this.Correo = Correo;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.especialidad = especialidad;
        this.InicioTrabajo = InicioTrabajo;
    }
    
    /*
    Constructor para extraer unicamente los datos que le mostraran al paciente 
    */
    public Medico(String codigo, String nombre, String colegiado, String correo, String horaEntrada, String horaSalida){
        this.Codigo = codigo;
        this.Nombre = nombre;
        this.Colegiado = colegiado;
        this.Correo = correo;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDPI() {
        return DPI;
    }

    public String getCodigo() {
        return Codigo;
    }

    public String getPassword() {
        return Password;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getColegiado() {
        return Colegiado;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public Date getInicioTrabajo() {
        return InicioTrabajo;
    }
    
    
}
