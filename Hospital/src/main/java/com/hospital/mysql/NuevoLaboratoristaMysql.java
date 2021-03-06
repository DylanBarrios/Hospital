package com.hospital.mysql;

import com.hospital.objetos.Laboratorista;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

public class NuevoLaboratoristaMysql {
    
    public boolean addLaboratorista(Laboratorista lab) {
        if (verificarCodigo(lab.getCodigo())) {
            JOptionPane.showMessageDialog(null, "Error, porfavor vuelva a cargar el formulario");
            return false;
        }else if(verificarDPI(lab.getDpi())){
            JOptionPane.showMessageDialog(null, "Error, ese DPI esta registrado ya");
            return false;
        }else {
            String sql = "INSERT INTO Laboratorista VALUES(?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
                //Encriptacion de la clave
                byte[] encodedBytes = Base64.encodeBase64(lab.getPassword().getBytes());
                Blob pass = new SerialBlob(encodedBytes);
                //Obteniendo fecha
                java.util.Date DateUtil = lab.getInicioTrabajo();
                java.sql.Date inicioTrabajo = new java.sql.Date(DateUtil.getTime());
                
                pst.setString(1, lab.getCodigo());
                pst.setString(2, lab.getExamen());
                pst.setString(3, lab.getNombre());
                pst.setString(4, lab.getRegistro());
                pst.setString(5, lab.getDpi());
                pst.setString(6, lab.getTelefono());
                pst.setString(7, lab.getCorreo());
                pst.setDate(8, inicioTrabajo);
                pst.setBlob(9, pass);
                pst.executeUpdate();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
                System.err.println("Error al agregar Nuevo Laboratorista: " + e);
                return false;
            }
        }
    }

    public boolean verificarCodigo(String Codigo) {
        String sql = "SELECT codigo FROM Laboratorista WHERE codigo = ?";

        try {
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            pst.setString(1, Codigo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar codigo al agregar Laboratorista" + e);
        }
        return false;
    }

    public boolean verificarDPI(String DPI) {
        String sql = "SELECT codigo FROM Laboratorista WHERE DPI = ?";

        try {
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            pst.setString(1, DPI);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar codigo al agregar medico por dpi" + e);
        }
        return false;
    }
}
