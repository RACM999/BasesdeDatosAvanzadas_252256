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
public class Instructor {
     private ObjectId _id;
    private String nombre;
    private String correo;
    private List<String> especialidades;
    private Integer aniosExperiencia;
    private String biografia;
    private Contacto contacto;
    private List<ObjectId> cursosImpartidos;

    private Date creadoEn;
    private Date actualizadoEn;

    public Instructor() {}

    public Instructor(ObjectId _id, String nombre, String correo, List<String> especialidades, Integer aniosExperiencia, String biografia, Contacto contacto, List<ObjectId> cursosImpartidos, Date creadoEn, Date actualizadoEn) {
        this._id = _id;
        this.nombre = nombre;
        this.correo = correo;
        this.especialidades = especialidades;
        this.aniosExperiencia = aniosExperiencia;
        this.biografia = biografia;
        this.contacto = contacto;
        this.cursosImpartidos = cursosImpartidos;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
    }

    

public ObjectId get_id() {
    return _id;
}

public void set_id(ObjectId _id) {
    this._id = _id;
}

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }

    public Integer getAniosExperiencia() {
        return aniosExperiencia;
    }

    public String getBiografia() {
        return biografia;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public List<ObjectId> getCursosImpartidos() {
        return cursosImpartidos;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public Date getActualizadoEn() {
        return actualizadoEn;
    }

   

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEspecialidades(List<String> especialidades) {
        this.especialidades = especialidades;
    }

    public void setAniosExperiencia(Integer aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public void setCursosImpartidos(List<ObjectId> cursosImpartidos) {
        this.cursosImpartidos = cursosImpartidos;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    public void setActualizadoEn(Date actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }
    
    
    
    
}
