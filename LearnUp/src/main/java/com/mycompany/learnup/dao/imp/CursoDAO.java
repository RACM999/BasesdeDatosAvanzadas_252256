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
import com.mycompany.learnup.models.Curso;

public class CursoDAO implements IModelDAO<Curso, ObjectId> {

    private final MongoCollection<Curso> coleccion;

    public CursoDAO() {
 this.coleccion = MongoClientProvider.INSTANCE
                .getCollection("cursos", Curso.class);    }

    @Override
    public Curso crear(Curso curso) {
        try {
            curso.set_id(new ObjectId());
            curso.setCreadoEn(new Date());
            curso.setActualizadoEn(new Date());

            coleccion.insertOne(curso);
            return curso;

        } catch (Exception e) {
            throw new DaoException("Error al crear curso", e);
        }
    }

    @Override
    public Curso buscarPorId(ObjectId id) {
        Curso c = coleccion.find(eq("_id", id)).first();

        if (c == null) {
            throw new EntidadNoEncontradaException("Curso no encontrado");
        }

        return c;
    }

    @Override
    public List<Curso> buscarTodos() {
        return coleccion.find().into(new ArrayList<>());
    }

    @Override
    public Curso actualizar(Curso curso) {
        curso.setActualizadoEn(new Date());
        coleccion.replaceOne(eq("_id", curso.get_id()), curso);
        return curso;
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
    public List<Curso> buscarPorNombre(String nombre) {
        return coleccion.find(eq("titulo", nombre)).into(new ArrayList<>());
    }
}