package com.hospital.objetos;

import java.util.Date;

public class HorarioDisponible {
    private Date fecha;
    private String hora;

    public HorarioDisponible(Date fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }
    
    
}
