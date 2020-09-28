package com.hospital.mysql;

import com.hospital.objetos.Medico;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

public class NuevoMedicoMysql {

    public boolean addMedico(Medico medico) {
        if (verificarCodigo(medico.getCodigo())) {
            JOptionPane.showMessageDialog(null, "Error, porfavor vuelva a cargar el formulario");
            return false;
        } else {
            String sql = "INSERT INTO Medico VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
                //Encriptacion de la clave
                byte[] encodedBytes = Base64.encodeBase64(medico.getPassword().getBytes());
                Blob password = new SerialBlob(encodedBytes);
                
                pst.setString(1, medico.getCodigo());
                pst.setString(2, medico.getNombre());
                pst.setString(3, medico.getDPI());
                pst.setBlob(4, password);
                pst.setString(5, medico.getTelefono());
                pst.setString(6, medico.getColegiado());
                pst.setString(7, medico.getCorreo());
                pst.setString(8, medico.getHoraEntrada());
                pst.setString(9, medico.getHoraSalida());

                java.util.Date DateUtil = medico.getInicioTrabajo();
                java.sql.Date inicioTrabajo = new java.sql.Date(DateUtil.getTime());

                pst.setDate(10, inicioTrabajo);
                pst.setString(11, medico.getEspecialidad());
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
        String sql = "SELECT codigo FROM Medico WHERE codigo = '" + Codigo + "'";

        try {
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
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
