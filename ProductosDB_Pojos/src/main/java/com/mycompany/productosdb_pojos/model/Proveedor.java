/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productosdb_pojos.model;

/**
 *
 * @author Roberto
 */
public class Proveedor {
    private String nombre;
    private String contacto;
    private String pais;

    public Proveedor() {
    }

    public Proveedor(String nombre, String contacto, String pais) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public String getPais() {
        return pais;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
    
}
