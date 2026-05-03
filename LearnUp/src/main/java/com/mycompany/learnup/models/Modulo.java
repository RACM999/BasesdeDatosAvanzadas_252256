/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnup.models;

import java.util.List;

/**
 *
 * @author Roberto
 */
public class Modulo {
     private String tituloModulo;
    private Integer duracionMinutos;
    private List<Recurso> recursos;

    public Modulo() {}

    public Modulo(String tituloModulo, Integer duracionMinutos, List<Recurso> recursos) {
        this.tituloModulo = tituloModulo;
        this.duracionMinutos = duracionMinutos;
        this.recursos = recursos;
    }

    public String getTituloModulo() {
        return tituloModulo;
    }

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setTituloModulo(String tituloModulo) {
        this.tituloModulo = tituloModulo;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }
    
    
}
