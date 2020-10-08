package com.hospital.mysql;

import com.hospital.objetos.ConsultaMedica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class NuevaConsultaMysql {

    public boolean addConsulta(ConsultaMedica consulta) throws ParseException {
        VerificarHorariosMedico vhm = new VerificarHorariosMedico();
        Date hora = new SimpleDateFormat("hh").parse(consulta.getHora());
        
        if (verificarCodigo(consulta.getCodigo())) {
            JOptionPane.showMessageDialog(null, "Error, porfavor vuelva a cargar el formulario");
            return false;
        }else if(vhm.verificarHoraCOnsulta(consulta.getMedico(), hora)){
            JOptionPane.showMessageDialog(null, "Error, la hora no esta disponible");
            return false;    
        }else {
            String sql = "INSERT INTO Consulta VALUES(?,?,?,?,?,?)";
            try {
                PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
                java.util.Date DateUtil = consulta.getFecha();
                java.sql.Date fechaCita = new java.sql.Date(DateUtil.getTime());
                pst.setString(1, consulta.getCodigo());
                pst.setString(2, consulta.getPaciente());
                pst.setString(3, consulta.getMedico());
                pst.setString(4, "IALF-7623");
                pst.setDate(5, fechaCita);
                pst.setString(6, consulta.getHora());
                pst.executeUpdate();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
                System.err.println("Error al agregar Nuevo Medico: " + e);
                return false;
            }
        }
    }

    public boolean verificarCodigo(String Codigo) {
        String sql = "SELECT codigo FROM Consulta WHERE codigo = ?";

        try {
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            pst.setString(1, Codigo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar codigo al agregar medico" + e);
        }
        return false;
    }
    
    
}
