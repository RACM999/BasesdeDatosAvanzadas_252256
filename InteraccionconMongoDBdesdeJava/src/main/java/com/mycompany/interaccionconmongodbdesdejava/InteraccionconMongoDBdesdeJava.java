/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.interaccionconmongodbdesdejava;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.Arrays;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Roberto
 */
public class InteraccionconMongoDBdesdeJava {

    public static void main(String[] args) {
        
        MongoClient cliente = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = cliente.getDatabase("restaurantesDB");
        MongoCollection<Document> col = db.getCollection("cafes");
        
        
        //1. Insertar un solo documento:
            Document document = new Document ();
            document.append("name", "Café de la Plaza");
            document.append("stars", 4.3);
            document.append("categories",  Arrays.asList(new String[]{"Café","Postres","Desayuno"}));
            col.insertOne(document);
        
        
        //2. Insertar varios documentos adicionales:
         ArrayList<Document>lista = new ArrayList<>();
         
        lista.add(new Document("name", "Espresso Express").append("stars", 4.8)
        .append("categories", Arrays.asList("Café","Rápido","Takeaway")));

        lista.add(new Document("name", "The Tea House").append("stars", 3.9)
        .append("categories", Arrays.asList("Té","Infusiones","Postres")));

        lista.add(new Document("name", "Morning Brew").append("stars", 4.0)
        .append("categories", Arrays.asList("Café","Desayuno","Bakery")));
        
        col.insertMany(lista);
        
        
        //3. Filtros para mostrar:
        
//            Documentos con stars >= 4.5.
                for(Document d: col.find(Filters.gte("stars", 4.5))){
                    System.out.println(d.toJson());

                }
//            Documentos cuyo nombre contiene "Café".
                for(Document d: col.find(Filters.regex("name", "Café"))){
                    System.out.println(d.toJson());
                }
//            Documentos con categories que incluyan "Postres".
                for(Document d: col.find(Filters.regex("categories","Postres"))){
                    System.out.println(d.toJson());
                }
//            Documentos con stars entre 3 y 4.3.
                  Bson filtro = Filters.and(Filters.gte("stars", 3), Filters.lte("stars", 4.3));
                    for(Document d: col.find(filtro)){
                        System.out.println(d.toJson());
                    }
//            Documentos cuyo nombre empieza con "T".
                 for(Document d: col.find(Filters.regex("name","^T"))){
                    System.out.println(d.toJson());
                }
        //4. Updates:
//        Cambiar stars a 4.5 para "Morning Brew".
            col.updateOne(Filters.eq("name", "Morning Brew"),Updates.set("stars",4.5));
//        Incrementar stars +0.2 para documentos con categories que contengan"Bakery" o "Desayuno".
            col.updateMany(Filters.in("categories", Arrays.asList("Bakery" , "Desayuno")),Updates.inc("stars",0.2));
//        Agregar campos phone = "555-111-2222" y open = true a "Café de la Plaza".
            col.updateOne(Filters.eq("name", "Café de la Plaza"),Updates.combine(Updates.set("Phone", "5551112222"),
                    Updates.set("open", true)));
        //5. Deletes:
//        Eliminar documento con name = "Espresso Express".
            col.deleteOne(Filters.eq("name", "Espresso Express"));
//        Eliminar todos los documentos con stars < 4.
            col.deleteMany(Filters.lt("stars", 4));
//        Eliminar documentos con categories que contengan "Takeaway" o "Infusiones".
            col.deleteMany(Filters.in("categories", Arrays.asList("Takeaway" , "Infusiones")));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
