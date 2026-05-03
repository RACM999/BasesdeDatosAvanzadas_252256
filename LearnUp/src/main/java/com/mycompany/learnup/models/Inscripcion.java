/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnup.models;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Roberto
 */
public class Inscripcion {
     private ObjectId cursoId;
    private Date fechaInscripcion;
    private Double progreso;
    private Resena resena;

    public Inscripcion() {
    }

    public Inscripcion(ObjectId cursoId, Date fechaInscripcion, Double progreso, Resena resena) {
        this.cursoId = cursoId;
        this.fechaInscripcion = fechaInscripcion;
        this.progreso = progreso;
        this.resena = resena;
    }

    public ObjectId getCursoId() {
        return cursoId;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public Double getProgreso() {
        return progreso;
    }

    public Resena getResena() {
        return resena;
    }

    public void setCursoId(ObjectId cursoId) {
        this.cursoId = cursoId;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public void setProgreso(Double progreso) {
        this.progreso = progreso;
    }

    public void setResena(Resena resena) {
        this.resena = resena;
    }
    
    
    
}
