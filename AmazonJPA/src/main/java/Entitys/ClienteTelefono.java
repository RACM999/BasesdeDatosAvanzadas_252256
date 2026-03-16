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
public class ClienteTelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String telefono;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    public ClienteTelefono() {
    }

    public ClienteTelefono(Long id, String telefono, Cliente cliente) {
        this.id = id;
        this.telefono = telefono;
        this.cliente = cliente;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTelefono() {
        return telefono;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        if (!(object instanceof ClienteTelefono)) {
            return false;
        }
        ClienteTelefono other = (ClienteTelefono) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.ClienteTelefono[ id=" + id + " ]";
    }
    
}
