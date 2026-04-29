/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.productosdb_pojos.dao;

import com.mycompany.productosdb_pojos.model.Producto;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Roberto
 */
public interface IProductoDAO {
    Producto create(Producto p);

    Producto findById(ObjectId id);

    List<Producto> findAll();

    boolean update(Producto p);

    boolean deleteById(ObjectId id);

    long deleteAll();

    List<Producto> findByNombre(String nombre);

    List<Producto> findByCategoria(String categoria);
}
