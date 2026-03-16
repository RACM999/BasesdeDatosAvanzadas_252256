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
import java.math.BigDecimal;

/**
 *
 * @author Roberto
 */
@Entity
public class PedidoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private BigDecimal precioVenta;
    private Integer cantidad;
    private BigDecimal importe;

    @ManyToOne
    @JoinColumn(name="id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto producto;

    public PedidoProducto() {
    }

    public PedidoProducto(Long id, BigDecimal precioVenta, Integer cantidad, BigDecimal importe, Pedido pedido, Producto producto) {
        this.id = id;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.importe = importe;
        this.pedido = pedido;
        this.producto = producto;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        if (!(object instanceof PedidoProducto)) {
            return false;
        }
        PedidoProducto other = (PedidoProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.PedidoProducto[ id=" + id + " ]";
    }
    
}
