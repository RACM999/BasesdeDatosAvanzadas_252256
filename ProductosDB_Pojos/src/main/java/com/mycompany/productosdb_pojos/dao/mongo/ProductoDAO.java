/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productosdb_pojos.dao.mongo;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mycompany.productosdb_pojos.config.MongoClientProvider;
import com.mycompany.productosdb_pojos.dao.IProductoDAO;
import com.mycompany.productosdb_pojos.exception.DaoException;
import com.mycompany.productosdb_pojos.exception.EntityNotFoundException;
import com.mycompany.productosdb_pojos.model.Producto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Roberto
 */
public class ProductoDAO implements IProductoDAO {
    private final MongoCollection<Producto> col;

    public ProductoDAO() {
        this.col = MongoClientProvider.INSTANCE
                .getCollection("productos", Producto.class);
    }

    @Override
    public Producto create(Producto p) {
        try {
            p.setId(new ObjectId());
            p.setCreatedAt(new Date());
            p.setUpdatedAt(new Date());

            col.insertOne(p);
            return p;

        } catch (MongoException e) {
            throw new DaoException("Error al crear producto", e);
        }
    }

    @Override
    public Producto findById(ObjectId id) {
        var p = col.find(Filters.eq("_id", id)).first();
        if (p == null) {
            throw new EntityNotFoundException("Producto no encontrado");
        }
        return p;
    }

    @Override
    public List<Producto> findAll() {
        return col.find().into(new ArrayList<>());
    }

    @Override
    public boolean update(Producto p) {
        try {
            var result = col.updateOne(
                Filters.eq("_id", p.getId()),
                Updates.combine(
                    Updates.set("nombre", p.getNombre()),
                    Updates.set("precio", p.getPrecio()),
                    Updates.set("stock", p.getStock()),
                    Updates.set("proveedor", p.getProveedor()),
                    Updates.set("categorias", p.getCategorias()),
                    Updates.set("updatedAt", new Date())
                )
            );

            if (result.getMatchedCount() == 0) {
                throw new EntityNotFoundException("Producto no encontrado");
            }

            return result.getModifiedCount() > 0;

        } catch (MongoException e) {
            throw new DaoException("Error al actualizar producto", e);
        }
    }

    @Override
    public boolean deleteById(ObjectId id) {
        var result = col.deleteOne(Filters.eq("_id", id));

        if (result.getDeletedCount() == 0) {
            throw new EntityNotFoundException("Producto no encontrado");
        }

        return true;
    }

    @Override
    public long deleteAll() {
        return col.deleteMany(new org.bson.Document()).getDeletedCount();
    }

    @Override
    public List<Producto> findByNombre(String nombre) {
        return col.find(Filters.eq("nombre", nombre)).into(new ArrayList<>());
    }

    @Override
    public List<Producto> findByCategoria(String categoria) {
        return col.find(Filters.in("categorias", categoria)).into(new ArrayList<>());
    }
}
