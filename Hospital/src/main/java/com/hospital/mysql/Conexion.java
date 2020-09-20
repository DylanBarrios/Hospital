package com.hospital.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static Connection connection = null;

    public Conexion() {
        String url = "jdbc:mysql://localhost:3306/Hospital";
        String user = "root";
        String password = "00";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            this.connection = con;
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

    }

    public static Connection getConnection() {
        return connection;
    }
}
