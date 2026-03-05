/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;

/**
 *
 * @author Roberto
 */
@Entity
@Table(name = "superheroes")
public class SuperHeroe implements Serializable{
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Column(unique = true, nullable = false)
    private String nombre;
    
    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private Universo universo;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Universo getUniverso() {
        return universo;
    }

    public IdentidadSecreta getIdentidadSecreta() {
        return identidadSecreta;
    }

    public String getFraseIconica() {
        return fraseIconica;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUniverso(Universo universo) {
        this.universo = universo;
    }

    public void setIdentidadSecreta(IdentidadSecreta identidadSecreta) {
        this.identidadSecreta = identidadSecreta;
    }

    public void setFraseIconica(String fraseIconica) {
        this.fraseIconica = fraseIconica;
    }

    public SuperHeroe(Long id, String nombre, Universo universo, IdentidadSecreta identidadSecreta, String fraseIconica) {
        this.id = id;
        this.nombre = nombre;
        this.universo = universo;
        this.identidadSecreta = identidadSecreta;
        this.fraseIconica = fraseIconica;
    }

    public SuperHeroe() {
       
    }
    
    
    @Embedded
    private IdentidadSecreta identidadSecreta;
    
    @Transient
    private String fraseIconica;
    
    
}
