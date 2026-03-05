/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.superheroesjpa;

import dao.ISuperHeroeDAO;
import dao.SuperHeroeDAO;
import entity.IdentidadSecreta;
import entity.SuperHeroe;
import entity.Universo;

/**
 *
 * @author Roberto
 */
public class SuperHeroesJPA {

    public static void main(String[] args) {
        ISuperHeroeDAO dao = new SuperHeroeDAO();
        
        
        
        SuperHeroe spiderman = new SuperHeroe( null,
                "Spider-Man", Universo.MARVEL,new IdentidadSecreta("Peter Parker", "New York" , "Fotografo"), "No digas mms mary jane"
        
        
        );
        
        SuperHeroe Batman = new SuperHeroe( null,
                "Batman", Universo.DC,new IdentidadSecreta("Bruno Diaz", "Gotham" , "Empresario"), "Por que soy batman"
        
        
        );
        
        SuperHeroe Pirata = new SuperHeroe( null,
                "El pirata de culiacan", Universo.INDEPENDIENTE,new IdentidadSecreta("Piratita", "Jalisco" , "Youtuber"), "Que rollo plebes"
        
        
        );
        
        dao.insertar(Pirata);
        dao.insertar(Batman);
        dao.insertar(spiderman);
        
        
        System.out.println("Lista inicial de SuperHeros:");
        dao.listar().forEach(h -> System.out.println(h.getId() + " - " + h.getNombre() + "{" + h.getUniverso()));
        
        
        SuperHeroe batmanBD = dao.buscar(Batman.getId());
        batmanBD.getIdentidadSecreta().setCiudad("Ciudad Gotica");
        dao.actualizar(batmanBD);
        
        System.out.println("Lista despues de modificar batman:");
        dao.listar().forEach(h -> System.out.println(h.getId() + " - " + h.getNombre() + "{" + h.getUniverso()));
        
        dao.eliminar(spiderman.getId());
        
        
        System.out.println("Lista despues de eliminar spiderman:");
        dao.listar().forEach(h -> System.out.println(h.getId() + " - " + h.getNombre() + "{" + h.getUniverso()));
        
    }
}
