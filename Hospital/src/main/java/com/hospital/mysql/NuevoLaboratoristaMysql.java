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
        } else {
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
                pst.setString(2, lab.getNombre());
                pst.setString(3, lab.getDpi());
                pst.setBlob(4, pass);
                pst.setString(5, lab.getTelefono());
                pst.setString(6, lab.getRegistro());
                pst.setString(7, lab.getCorreo());
                pst.setDate(8, inicioTrabajo);
                pst.setString(9, lab.getExamen());
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
        String sql = "SELECT codigo FROM Laboratorista WHERE codigo = '" + Codigo + "'";

        try {
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar codigo al agregar Laboratorista" + e);
        }
        return false;
    }

}
