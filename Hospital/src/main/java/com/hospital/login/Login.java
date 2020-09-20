package com.hospital.login;

public class Login {

    private String DPI, Password, Rol;

    public Login(String DPI, String Password, String Rol) {
        this.DPI = DPI;
        this.Password = Password;
        this.Rol = Rol;
    }

    public String getDPI() {
        return DPI;
    }

    public String getPassword() {
        return Password;
    }

    public String getRol() {
        return Rol;
    }
    
    
}
