package com.hospital.objetos;

import java.util.Date;

public class ConsultaMedica {
    String Codigo;
    String Paciente;
    String Medico;
    String Especialidad;
    String Hora;
    Date fecha;

    public ConsultaMedica(String Codigo, String Paciente, String Medico, String Especialidad, String Hora, Date fecha) {
        this.Codigo = Codigo;
        this.Paciente = Paciente;
        this.Medico = Medico;
        this.Especialidad = Especialidad;
        this.Hora = Hora;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return Codigo;
    }

    public String getPaciente() {
        return Paciente;
    }

    public String getMedico() {
        return Medico;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public String getHora() {
        return Hora;
    }

    public Date getFecha() {
        return fecha;
    }
    
    
}
