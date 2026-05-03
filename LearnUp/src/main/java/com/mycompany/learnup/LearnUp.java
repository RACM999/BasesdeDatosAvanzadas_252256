/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.learnup;

import com.mycompany.learnup.config.MongoClientProvider;
import com.mycompany.learnup.dao.imp.UsuarioDAO;
import com.mycompany.learnup.models.Usuario;

/**
 *
 * @author Roberto
 */
public class LearnUp {

    public static void main(String[] args) {
         try {
            MongoClientProvider.INSTANCE.init();
            UsuarioDAO dao = new UsuarioDAO();

            Usuario u = new Usuario();
            u.setNombre("Roberto");
            u.setCorreo("roberto@test.com");

            dao.crear(u);
            System.out.println("Creado: " + u.get_id());

            Usuario encontrado = dao.buscarPorId(u.get_id());
            System.out.println("Encontrado: " + encontrado.getNombre());

            encontrado.setNombre("Nuevo Nombre");
            dao.actualizar(encontrado);

            System.out.println("Total: " + dao.buscarTodos().size());

            dao.eliminarPorId(u.get_id());
            System.out.println("Eliminado");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
