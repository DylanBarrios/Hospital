package com.hospital.objetos;

public class Login {

    private String Rol, Password;
    private static String DPI;

    public Login(String DPI, String Password, String Rol) {
        Login.DPI = DPI;
        this.Password = Password;
        this.Rol = Rol;
    }

    public static String getDPI() {
        return DPI;
    }

    public String getPassword() {
        return Password;
    }

    public String getRol() {
        return Rol;
    }

    
}
