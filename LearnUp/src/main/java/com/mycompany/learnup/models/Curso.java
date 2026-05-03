/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnup.models;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Roberto
 */
public class Curso {
     private ObjectId _id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private ObjectId instructorId;
    private Double precio;
    private Double calificacion;
    private List<String> etiquetas;
    private List<Modulo> modulos;

    private Date creadoEn;
    private Date actualizadoEn;

    public Curso() {}

    public Curso(ObjectId _id, String titulo, String descripcion, String categoria, ObjectId instructorId, Double precio, Double calificacion, List<String> etiquetas, List<Modulo> modulos, Date creadoEn, Date actualizadoEn) {
        this._id = _id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.instructorId = instructorId;
        this.precio = precio;
        this.calificacion = calificacion;
        this.etiquetas = etiquetas;
        this.modulos = modulos;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
    }

    public ObjectId get_id() {
    return _id;
}

public void set_id(ObjectId _id) {
    this._id = _id;
}

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public ObjectId getInstructorId() {
        return instructorId;
    }

    public Double getPrecio() {
        return precio;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public Date getActualizadoEn() {
        return actualizadoEn;
    }

   

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setInstructorId(ObjectId instructorId) {
        this.instructorId = instructorId;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    public void setActualizadoEn(Date actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    
    
    
}
