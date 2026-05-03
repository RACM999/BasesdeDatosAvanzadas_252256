/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnup.dao.imp;



import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;

import java.util.*;

import static com.mongodb.client.model.Filters.eq;
import com.mycompany.learnup.config.MongoClientProvider;
import com.mycompany.learnup.dao.IModelDAO;
import com.mycompany.learnup.dao.exception.DaoException;
import com.mycompany.learnup.dao.exception.EntidadNoEncontradaException;
import com.mycompany.learnup.models.Usuario;

/**
 *
 * @author Roberto
 */
public class UsuarioDAO implements IModelDAO<Usuario, ObjectId> {

    private final MongoCollection<Usuario> coleccion;

    public UsuarioDAO() {
        this.coleccion = MongoClientProvider.INSTANCE.getCollection("usuarios", Usuario.class);    }

    @Override
    public Usuario crear(Usuario usuario) {
        try {
            usuario.set_id(new ObjectId());
            usuario.setCreadoEn(new Date());
            usuario.setActualizadoEn(new Date());

            coleccion.insertOne(usuario);
            return usuario;

        } catch (Exception e) {
            throw new DaoException("Error al crear usuario", e);
        }
    }

    @Override
    public Usuario buscarPorId(ObjectId id) {
        Usuario u = coleccion.find(eq("_id", id)).first();

        if (u == null) {
            throw new EntidadNoEncontradaException("Usuario no encontrado");
        }

        return u;
    }

    @Override
    public List<Usuario> buscarTodos() {
        return coleccion.find().into(new ArrayList<>());
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        usuario.setActualizadoEn(new Date());
        coleccion.replaceOne(eq("_id", usuario.get_id()), usuario);
        return usuario;
    }

    @Override
    public void eliminarPorId(ObjectId id) {
        coleccion.deleteOne(eq("_id", id));
    }

    @Override
    public void eliminarTodos() {
        coleccion.deleteMany(new org.bson.Document());
    }

    @Override
    public List<Usuario> buscarPorNombre(String nombre) {
        return coleccion.find(eq("nombre", nombre)).into(new ArrayList<>());
    } 
}
