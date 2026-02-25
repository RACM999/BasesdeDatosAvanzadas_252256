/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendajpa;

/**
 *
 * @author Roberto
 */
public class TiendaJPA {

    public static void main(String[] args) {
      ProductoDAO dao = new ProductoDAO();
      
      
      
      //Insertar
      Producto p1 = new Producto();
      p1.setNombre("Laptop");
      p1.setPrecio(15000.0);
      dao.insertar(p1);
      
      
      //Buscar 
      Producto buscado = dao.buscar(1);
      System.out.println("Producto Encontrado:" + buscado.getNombre());
      
      
      //Actualizar 
      buscado.setPrecio(14000.0);
      dao.actualizar(buscado);
      
      //Eliminar 
      dao.eliminar(1);
        
        
        
        
        
        
        
    }
}
