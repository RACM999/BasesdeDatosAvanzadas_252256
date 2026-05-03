/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnup.models;

/**
 *
 * @author Roberto
 */
public class Recurso {
    private String tipo;
    private String titulo;
    private String url;

    public Recurso() {}

    public Recurso(String tipo, String titulo, String url) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.url = url;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
