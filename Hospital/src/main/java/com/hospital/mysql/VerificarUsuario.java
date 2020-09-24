package com.hospital.mysql;

import com.hospital.login.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class VerificarUsuario {

    public boolean verificar(Login login) {
        switch (login.getRol()) {
            case "Paciente":
                break;
            case "Medico":
                break;
            case "Administrador":
                String sql = "SELECT nombre FROM Administrador WHERE clave = '" + login.getPassword() + "' AND DPI = '" + login.getDPI() + "'";
                return VerificarUsuario(sql);
            default:
                break;
        }
        return false;
    }

    public boolean VerificarUsuario(String sql) {   
        try {
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar usuario " + e);
        }
        return false;
    }

}
