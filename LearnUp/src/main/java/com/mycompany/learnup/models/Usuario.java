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
public class Usuario {
      private ObjectId _id;
    private String nombre;
    private String correo;

    private List<Inscripcion> cursosInscritos;
    private List<String> intereses;
    private Configuracion configuracion;

    private Date creadoEn;
    private Date actualizadoEn;

    public Usuario() {}

    public Usuario(ObjectId _id, String nombre, String correo, List<Inscripcion> cursosInscritos, List<String> intereses, Configuracion configuracion, Date creadoEn, Date actualizadoEn) {
        this._id = _id;
        this.nombre = nombre;
        this.correo = correo;
        this.cursosInscritos = cursosInscritos;
        this.intereses = intereses;
        this.configuracion = configuracion;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
    }

    public ObjectId get_id() { return _id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public List<Inscripcion> getCursosInscritos() { return cursosInscritos; }
    public void setCursosInscritos(List<Inscripcion> cursosInscritos) { this.cursosInscritos = cursosInscritos; }

    public List<String> getIntereses() { return intereses; }
    public void setIntereses(List<String> intereses) { this.intereses = intereses; }

    public Configuracion getConfiguracion() { return configuracion; }
    public void setConfiguracion(Configuracion configuracion) { this.configuracion = configuracion; }

    public Date getCreadoEn() { return creadoEn; }
    public void setCreadoEn(Date creadoEn) { this.creadoEn = creadoEn; }

    public Date getActualizadoEn() { return actualizadoEn; }
    public void setActualizadoEn(Date actualizadoEn) { this.actualizadoEn = actualizadoEn; }
}
