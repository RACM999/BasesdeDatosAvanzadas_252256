/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Roberto
 */
@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    @Column (name = "ap_paterno")
    private String apPaterno;
    
    @Column (name = "ap_materno")
    private String apMaterno;

    @Column (name = "fch_nac")
    private LocalDate fchnac;
    
    private Integer edad;
    

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "cliente")
    private List<ClienteTelefono> telefonos;

    @OneToMany(mappedBy = "cliente")
    private List<ClienteCorreo> correos;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String apPaterno, String apMaterno, LocalDate fchnac, Integer edad, List<Pedido> pedidos, List<ClienteTelefono> telefonos, List<ClienteCorreo> correos) {
        this.id = id;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.fchnac = fchnac;
        this.edad = edad;
        this.pedidos = pedidos;
        this.telefonos = telefonos;
        this.correos = correos;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public LocalDate getFchnac() {
        return fchnac;
    }

    public Integer getEdad() {
        return edad;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<ClienteTelefono> getTelefonos() {
        return telefonos;
    }

    public List<ClienteCorreo> getCorreos() {
        return correos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public void setFchnac(LocalDate fchnac) {
        this.fchnac = fchnac;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setTelefonos(List<ClienteTelefono> telefonos) {
        this.telefonos = telefonos;
    }

    public void setCorreos(List<ClienteCorreo> correos) {
        this.correos = correos;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Cliente[ id=" + id + " ]";
    }
    
}
