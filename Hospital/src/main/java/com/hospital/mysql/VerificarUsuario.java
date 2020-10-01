package com.hospital.mysql;

import com.hospital.objetos.Login;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author dylan
 */
public class VerificarUsuario {
    public static String codigoUsuario;

    public String verificar(Login login) {
        String sql;
        switch (login.getRol()) {
            case "Paciente":
                sql = "SELECT codigo FROM Paciente WHERE password = ? AND DPI = ?";
                if (VerificarUsuario(sql, login)) {
                    return "jsp/PaginaPaciente.jsp";
                } else {
                    return "index.jsp";
                }
            case "Medico":
                sql = "SELECT codigo FROM Medico WHERE password = ? AND DPI = ?";
                if (VerificarUsuario(sql, login)) {
                    return "jsp/PaginaPaciente.jsp";
                } else {
                    return "index.jsp";
                }
            case "Administrador":
                sql = "SELECT codigo FROM Administrador WHERE clave = ? AND DPI = ?";
                if (VerificarUsuario(sql, login)) {
                    return "jsp/PaginaPrincipal.jsp";
                } else {
                    return "index.jsp";
                }
            case "Laboratorista":
                sql = "SELECT codigo FROM Laboratorista WHERE password = ? AND DPI = ?";
                if (VerificarUsuario(sql, login)) {
                    return "jsp/PaginaPrincipal.jsp";
                } else {
                    return "index.jsp";
                }
            default:
                break;
        }
        return null;
    }

    public boolean VerificarUsuario(String sql, Login login) {
        try {
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            //Encriptacion de la clave
            byte[] encodedBytes = Base64.encodeBase64(login.getPassword().getBytes());
            Blob password = new SerialBlob(encodedBytes);

            pst.setBlob(1, password);
            pst.setString(2, login.getDPI());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                codigoUsuario = rs.getString("codigo");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar usuario " + e);
        }
        return false;
    }
    
    public static String getCodigoUsuario(){
        return codigoUsuario;
    }

}
