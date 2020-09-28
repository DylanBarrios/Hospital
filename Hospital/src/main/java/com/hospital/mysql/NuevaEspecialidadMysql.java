package com.hospital.mysql;

import com.hospital.objetos.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NuevaEspecialidadMysql {

    public boolean addEspecialidad(Especialidad especialidad) {
        if (verificarCodigo(especialidad.getCodigo())) {
            JOptionPane.showMessageDialog(null, "Error, porfavor vuelva a cargar el formulario");
            return false;
        } else {
            String sql = "INSERT INTO Especialidad VALUES(?,?,?)";
            try {
                PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
                pst.setString(1, especialidad.getCodigo());
                pst.setString(2, especialidad.getNombre());
                pst.setDouble(3, especialidad.getCosto());
                pst.executeUpdate();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
                System.err.println("Error al agregar Nueva Especialidad: " + e);
                return false;
            }
        }
    }

    public boolean verificarCodigo(String Codigo) {
        String sql = "SELECT codigo FROM Especialidad WHERE Codigo = '" + Codigo + "'";

        try {
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar codigo al crear nueva especialidad" + e);
        }
        return false;
    }

    public ArrayList<Especialidad> getEspecialidades() {
        String sql = "SELECT * FROM Especialidad";

        try {
            ArrayList<Especialidad> arrayEsp = new ArrayList<Especialidad>();
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double costo = rs.getDouble("costo");
                Especialidad especialidad = new Especialidad(Codigo, nombre, costo);
                arrayEsp.add(especialidad);
            }
            return arrayEsp;
        } catch (SQLException e) {
            System.err.println("Error al verificar codigo al crear nueva especialidad" + e);
            return null;    
        }
    }
}
