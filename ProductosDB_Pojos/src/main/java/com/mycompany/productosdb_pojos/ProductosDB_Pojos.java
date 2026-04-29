/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productosdb_pojos;

import com.mycompany.productosdb_pojos.dao.IProductoDAO;
import com.mycompany.productosdb_pojos.dao.mongo.ProductoDAO;
import com.mycompany.productosdb_pojos.model.Producto;
import com.mycompany.productosdb_pojos.model.Proveedor;
import java.util.Arrays;

/**
 *
 * @author Roberto
 */
public class ProductosDB_Pojos {

    public static void main(String[] args) {
         IProductoDAO dao = new ProductoDAO();

        try {
            // Crear
            Producto p = new Producto();
            p.setNombre("Laptop");
            p.setPrecio(15000.0);
            p.setStock(10);

            Proveedor prov = new Proveedor();
            prov.setNombre("Dell");
            prov.setContacto("dell@email.com");
            prov.setPais("USA");

            p.setProveedor(prov);
            p.setCategorias(Arrays.asList("Tecnología", "Computación"));

            p = dao.create(p);
            System.out.println("Creado: " + p.getId());

            // Leer
            var encontrado = dao.findById(p.getId());
            System.out.println("Encontrado: " + encontrado.getNombre());

            // Actualizar
            encontrado.setPrecio(14000.0);
            dao.update(encontrado);

            // Listar
            dao.findAll().forEach(prod -> 
                System.out.println(prod.getNombre())
            );

            // Eliminar
            dao.deleteById(p.getId());
            System.out.println("Eliminado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
