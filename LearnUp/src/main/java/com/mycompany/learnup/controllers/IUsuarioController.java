/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.learnup.controllers;

import com.mycompany.learnup.models.Usuario;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Roberto
 */
public interface IUsuarioController {
     Usuario crear(Usuario u);
    Usuario obtenerPorId(ObjectId id);
    List<Usuario> obtenerTodos();
    Usuario actualizar(Usuario u);
    void eliminar(ObjectId id);
}
