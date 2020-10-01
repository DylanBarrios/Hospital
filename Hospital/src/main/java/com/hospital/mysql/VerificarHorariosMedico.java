package com.hospital.mysql;

import com.hospital.objetos.HorarioDisponible;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VerificarHorariosMedico {

    public boolean verificarHoraCOnsulta(String CodMedico, Date hora) throws ParseException {
        String sql = "SELECT horaEntrada,horaSalida FROM Medico WHERE codigo = ?";
        try {
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            pst.setString(1, CodMedico);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String entrada = rs.getString("horaEntrada");
                String salida = rs.getString("horaSalida");
        
                Date horaEntrada = new SimpleDateFormat("hh:mm").parse(entrada);
                Date horaSalida = new SimpleDateFormat("hh:mm").parse(salida);
                
                if (hora.compareTo(horaEntrada) > 0) {
                    if (hora.compareTo(horaSalida) < 0) {
                        return false;
                    }else
                        return true;
                }else
                    return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar codigo al agregar medico" + e);
        }
        return true;
    }
    
    public ArrayList<Date> getCitas(String medico, String fecha) throws ParseException {
        String sql = "SELECT hora FROM Consulta WHERE medico = ? AND fecha = ?";

        try {
            ArrayList<Date> horarios = new ArrayList<Date>();
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            pst.setString(1, medico);
            pst.setString(2, fecha);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String horaString = rs.getString("hora");
                Date hora = new SimpleDateFormat("hh:mm").parse(horaString);
                horarios.add(hora);
            }
            return horarios;
        } catch (SQLException e) {
            System.err.println("Error al extraer medicos para paciente: " + e);
            return null;
        }
    }
}
