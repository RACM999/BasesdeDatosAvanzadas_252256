/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnup.models;

/**
 *
 * @author Roberto
 */
public class Contacto {
     private String telefono;
    private String linkedin;
    private String sitioWeb;

    public Contacto() {}

    public Contacto(String telefono, String linkedin, String sitioWeb) {
        this.telefono = telefono;
        this.linkedin = linkedin;
        this.sitioWeb = sitioWeb;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }
    
    
}
