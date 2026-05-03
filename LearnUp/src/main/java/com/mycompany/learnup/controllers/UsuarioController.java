/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnup.controllers;

import com.mycompany.learnup.dao.imp.UsuarioDAO;
import com.mycompany.learnup.models.Usuario;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Roberto
 */
public class UsuarioController implements IUsuarioController {

    private final UsuarioDAO dao = new UsuarioDAO();

    @Override
    public Usuario crear(Usuario u) {
        return dao.crear(u);
    }

    @Override
    public Usuario obtenerPorId(ObjectId id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return dao.buscarTodos();
    }

    @Override
    public Usuario actualizar(Usuario u) {
        return dao.actualizar(u);
    }

    @Override
    public void eliminar(ObjectId id) {
        dao.eliminarPorId(id);
    }
}