/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnup.dao;

import java.util.List;

/**
 *
 * @author Roberto
 */
public interface IModelDAO<T, ID> {
     T crear(T entidad);
    T buscarPorId(ID id);
    List<T> buscarTodos();
    T actualizar(T entidad);
    void eliminarPorId(ID id);
    void eliminarTodos();

    List<T> buscarPorNombre(String nombre);
}
