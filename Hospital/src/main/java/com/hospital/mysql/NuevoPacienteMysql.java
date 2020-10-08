package com.hospital.mysql;

import org.apache.commons.codec.binary.Base64;
import com.hospital.objetos.Paciente;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;

public class NuevoPacienteMysql {

    public boolean addPaciente(Paciente paciente) {
        if (verificarCodigo(paciente.getCodigo())) {
            JOptionPane.showMessageDialog(null, "Error, porfavor vuelva a cargar el formulario");
            return false;
        } else if (verificarDPI(paciente.getDPI())) {
            JOptionPane.showMessageDialog(null, "El DPI ya existe, ud esta duplicando identidad, llamaremos al FBI");
            return false;
        } else {
            String sql = "INSERT INTO Paciente VALUES(?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
                //Encriptacion de la clave
                byte[] encodedBytes = Base64.encodeBase64(paciente.getPassword().getBytes());
                Blob blob = new SerialBlob(encodedBytes);
                //Obteniendo fecha
                java.util.Date DateUtil = paciente.getNacimiento();
                java.sql.Date nacimiento = new java.sql.Date(DateUtil.getTime());

                pst.setString(1, paciente.getCodigo());
                pst.setString(2, paciente.getNombre());
                pst.setString(3, paciente.getSexo());
                pst.setDate(4, nacimiento);
                pst.setString(5, paciente.getDPI());
                pst.setString(6, paciente.getTelefono());
                pst.setDouble(7, paciente.getPeso());
                pst.setString(8, paciente.getSangre());
                pst.setString(9, paciente.getCorreo());
                pst.setBlob(10, blob);
                pst.executeUpdate();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
                System.err.println("Error al agregar Nuevo Paciente: " + e);
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

    public boolean verificarDPI(String DPI) {
        String sql = "SELECT codigo FROM Paciente WHERE DPI = ?";

        try {
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            pst.setString(1, DPI);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar codigo al agregar Paciente" + e);
        }
        return false;
    }

}
