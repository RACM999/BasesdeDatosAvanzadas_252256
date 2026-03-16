/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 *
 * @author Roberto
 */
@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    
    
    private LocalDateTime fecha; 
    
    
    @Enumerated(EnumType.STRING)
    @Column(name = "met_pago", nullable = false)
    private MetodoPago metodoPago;
    
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    
   @OneToMany(mappedBy = "pedido")
   private Set<PedidoDetalle> pedidos;

    public Pedido() {
    }

    public Pedido(Long id, LocalDateTime fecha, MetodoPago metodoPago, Cliente cliente, Set<PedidoDetalle> pedidos) {
        this.id = id;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.cliente = cliente;
        this.pedidos = pedidos;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Set<PedidoDetalle> getPedidos() {
        return pedidos;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPedidos(Set<PedidoDetalle> pedidos) {
        this.pedidos = pedidos;
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Pedido[ id=" + id + " ]";
    }
    
}
