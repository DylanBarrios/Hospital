package com.hospital.mysql;

import com.hospital.objetos.Examen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NuevoExamenMysql {
   
    public boolean addExamen(Examen examen) {
        if (verificarCodigo(examen.getCodigo())) {
            JOptionPane.showMessageDialog(null, "Error, porfavor vuelva a cargar el formulario");
            return false;
        } else {
            String sql = "INSERT INTO Examen VALUES(?,?,?,?,?,?)";
            try {
                PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
                                
                pst.setString(1, examen.getCodigo());
                pst.setString(2, examen.getNombre());
                pst.setBoolean(3, examen.isOrden());
                pst.setString(4, examen.getDescripcion());
                pst.setDouble(5, examen.getCosto());
                pst.setString(6, examen.getTipoInforme());
                pst.executeUpdate();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
                System.err.println("Error al agregar Nuevo Examen: " + e);
                return false;
            }
        }
    }

    public boolean verificarCodigo(String Codigo) {
        String sql = "SELECT codigo FROM Paciente WHERE codigo = '" + Codigo + "'";

        try {
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar codigo al agregar Paciente" + e);
        }
        return false;
    }
    
    public ArrayList<Examen> getExamenes() {
        String sql = "SELECT * FROM Examen";

        try {
            ArrayList<Examen> arrayEx = new ArrayList<Examen>();
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("Descripcion");
                String informe = rs.getString("tipoInforme");
                boolean orden = rs.getBoolean("ordenMedica");
                Double costo = rs.getDouble("costo");
                
                Examen examen = new Examen(Codigo, nombre, informe, costo, descripcion, orden);
                arrayEx.add(examen);
            }
            return arrayEx;
        } catch (SQLException e) {
            System.err.println("Error al verificar codigo al crear nueva especialidad" + e);
            return null;    
        }
    }
}
