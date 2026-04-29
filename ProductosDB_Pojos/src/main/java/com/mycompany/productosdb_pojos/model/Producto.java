/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productosdb_pojos.model;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Roberto
 */
public class Producto {
    private ObjectId _id;
    private String nombre;
    private Double precio;
    private Integer stock;

    private Proveedor proveedor;
    private List<String> categorias;

    private Date createdAt;
    private Date updatedAt;

    public Producto() {
    }

    public Producto(ObjectId _id, String nombre, Double precio, Integer stock, Proveedor proveedor, List<String> categorias, Date createdAt, Date updatedAt) {
        this._id = _id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.proveedor = proveedor;
        this.categorias = categorias;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ObjectId getId() {
        return _id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    
    
    
}
