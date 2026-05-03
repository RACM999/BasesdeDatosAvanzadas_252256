/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnup.dao.imp;

/**
 *
 * @author Roberto
 */
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;

import java.util.*;

import static com.mongodb.client.model.Filters.eq;
import com.mycompany.learnup.config.MongoClientProvider;
import com.mycompany.learnup.dao.IModelDAO;
import com.mycompany.learnup.dao.exception.DaoException;
import com.mycompany.learnup.dao.exception.EntidadNoEncontradaException;
import com.mycompany.learnup.models.Instructor;

public class InstructorDAO implements IModelDAO<Instructor, ObjectId> {

    private final MongoCollection<Instructor> coleccion;

    public InstructorDAO() {
        this.coleccion = MongoClientProvider.INSTANCE
                .getCollection("instructores", Instructor.class);
    }

    @Override
    public Instructor crear(Instructor inst) {
        try {
            inst.set_id(new ObjectId());
            inst.setCreadoEn(new Date());
            inst.setActualizadoEn(new Date());

            coleccion.insertOne(inst);
            return inst;

        } catch (Exception e) {
            throw new DaoException("Error al crear instructor", e);
        }
    }

    @Override
    public Instructor buscarPorId(ObjectId id) {
        Instructor i = coleccion.find(eq("_id", id)).first();

        if (i == null) {
            throw new EntidadNoEncontradaException("Instructor no encontrado");
        }

        return i;
    }

    @Override
    public List<Instructor> buscarTodos() {
        return coleccion.find().into(new ArrayList<>());
    }

    @Override
    public Instructor actualizar(Instructor inst) {
        inst.setActualizadoEn(new Date());
        coleccion.replaceOne(eq("_id", inst.get_id()), inst);
        return inst;
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
    public List<Instructor> buscarPorNombre(String nombre) {
        return coleccion.find(eq("nombre", nombre)).into(new ArrayList<>());
    }
}