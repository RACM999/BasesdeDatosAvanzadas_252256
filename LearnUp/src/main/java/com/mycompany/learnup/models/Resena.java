/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnup.models;

import java.util.Date;

/**
 *
 * @author Roberto
 */
public class Resena {
    private Integer calificacion;
    private String comentario;
    private Date fecha;

    public Resena() {
    }

    public Resena(Integer calificacion, String comentario, Date fecha) {
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
