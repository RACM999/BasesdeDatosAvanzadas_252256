/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entitys;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

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
    
    @OneToOne
    @JoinColumn(name = "cliente_recomienda_id", referencedColumnName = "id")
    private Cliente clienteRecomienda;
    
    
    @ElementCollection
    @CollectionTable(name = "Cliente_Telefonos", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "telefono")
    private Set<String> Telefonos;
    
    
     
    @ElementCollection
    @CollectionTable(name = "Cliente_Preferencias", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "preferencia")
    private Set<String> preferencias;

    
    @OneToMany(mappedBy ="cliente")
    private Set<Pedido> pedidos;
    
    
    
    
    
    
    
    
    public Cliente() {
    }

    public Cliente(Long id, String nombre, String apPaterno, String apMaterno, LocalDate fchnac, Cliente clienteRecomienda, Set<String> Telefonos, Set<String> preferencias) {
        this.id = id;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.fchnac = fchnac;
        this.clienteRecomienda = clienteRecomienda;
        this.Telefonos = Telefonos;
        this.preferencias = preferencias;
    }

    public Cliente(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
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

    public Cliente getClienteRecomienda() {
        return clienteRecomienda;
    }

    public Set<String> getTelefonos() {
        return Telefonos;
    }

    public Set<String> getPreferencias() {
        return preferencias;
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

    public void setClienteRecomienda(Cliente clienteRecomienda) {
        this.clienteRecomienda = clienteRecomienda;
    }

    public void setTelefonos(Set<String> Telefonos) {
        this.Telefonos = Telefonos;
    }

    public void setPreferencias(Set<String> preferencias) {
        this.preferencias = preferencias;
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
