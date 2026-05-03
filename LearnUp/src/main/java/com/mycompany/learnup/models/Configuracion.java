/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnup.models;

/**
 *
 * @author Roberto
 */
public class Configuracion {
     private Boolean notificaciones;
    private Boolean modoOscuro;
    private String idioma;

    public Configuracion() {}

    public Configuracion(Boolean notificaciones, Boolean modoOscuro, String idioma) {
        this.notificaciones = notificaciones;
        this.modoOscuro = modoOscuro;
        this.idioma = idioma;
    }

    public Boolean getNotificaciones() {
        return notificaciones;
    }

    public Boolean getModoOscuro() {
        return modoOscuro;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setNotificaciones(Boolean notificaciones) {
        this.notificaciones = notificaciones;
    }

    public void setModoOscuro(Boolean modoOscuro) {
        this.modoOscuro = modoOscuro;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    
}
