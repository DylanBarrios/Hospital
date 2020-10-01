package com.hospital.mysql;

import com.hospital.objetos.Medico;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

public class NuevoMedicoMysql {

    public boolean addMedico(Medico medico) {
        if (verificarCodigo(medico.getCodigo())) {
            JOptionPane.showMessageDialog(null, "Error, porfavor vuelva a cargar el formulario");
            return false;
        }else if(verificarDPI(medico.getDPI())){
            JOptionPane.showMessageDialog(null, "Error, ese DPI esta registrado ya");
            return false;
        }else if(verificarColegiado(medico.getColegiado())){
            JOptionPane.showMessageDialog(null, "Error, ese colegiado esta registrado ya");
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
        String sql = "SELECT codigo FROM Medico WHERE codigo = ?";

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
    
     public boolean verificarDPI(String DPI) {
        String sql = "SELECT codigo FROM Medico WHERE DPI = ?";

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
     
     public boolean verificarColegiado(String colegiado) {
        String sql = "SELECT codigo FROM Medico WHERE colegiado = ?";

        try {
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            pst.setString(1, colegiado);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar codigo al agregar medico por dpi" + e);
        }
        return false;
    }

    public String getEspecialidad(String codigo) {
        String sql = "select nombre from Especialidad where codigo= ?";
        try {
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString("nombre");
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar codigo al agregar medico" + e);
        }
        return null;
    }

    public ArrayList<Medico> getMedicos() {
        String sql = "SELECT * FROM Medico ORDER BY nombre";

        try {
            ArrayList<Medico> arrayMedicos = new ArrayList<Medico>();
            PreparedStatement pst = Conexion.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String colegiado = rs.getString("colegiado");
                String correo = rs.getString("correo");
                String horaEntrada = rs.getString("horaEntrada");
                String horaSalida = rs.getString("horaSalida");
                String especialidad = rs.getString("especialidad");

                Medico medico = new Medico(codigo, nombre, colegiado, correo, horaEntrada, horaSalida, especialidad);
                arrayMedicos.add(medico);
            }
            return arrayMedicos;
        } catch (SQLException e) {
            System.err.println("Error al extraer medicos para paciente: " + e);
            return null;
        }
    }
}
