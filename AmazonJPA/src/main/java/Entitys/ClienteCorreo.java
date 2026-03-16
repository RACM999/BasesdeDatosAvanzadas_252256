/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 * @author Roberto
 */
@Entity
public class ClienteCorreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String correo;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    public ClienteCorreo() {
    }

    public ClienteCorreo(Long id, String correo, Cliente cliente) {
        this.id = id;
        this.correo = correo;
        this.cliente = cliente;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCorreo() {
        return correo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        if (!(object instanceof ClienteCorreo)) {
            return false;
        }
        ClienteCorreo other = (ClienteCorreo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.ClienteCorreo[ id=" + id + " ]";
    }
    
}
