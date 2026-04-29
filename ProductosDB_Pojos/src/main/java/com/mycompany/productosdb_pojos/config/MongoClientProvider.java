/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.productosdb_pojos.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Roberto
 */
public enum MongoClientProvider {
    INSTANCE;
    
    private MongoClient client;
    private  String dbName = "ProductosDB";
    private String uri = "mongodb://localhost:27017";
    
    
    public synchronized  void init(){
        if(client == null){
            client = MongoClients.create(MongoConfig.buildSettings(this.uri));
        
        }
    Runtime.getRuntime().addShutdownHook(new Thread(() ->{
        try{
            client.close();
        
        }catch(Exception ignored){}
    
    }));
    
    }
    
    
    public MongoClient client(){
        Exception IllegalStateException;
            if(client == null)
                throw new IllegalStateException("El cliente no ha sido iniciado");
            
            return client;
    
    
    
    }
    
    public MongoDatabase database(){
        
        if(client == null)
                throw new IllegalStateException("El cliente no ha sido iniciado");
        return client().getDatabase(this.dbName);
    
    
    }
    
    
    
    
    public <T> MongoCollection<T> getCollection(String collectionName, Class<T> clazz){
        if(client == null)
                throw new IllegalStateException("El cliente no ha sido iniciado");
            
           MongoDatabase db = client.getDatabase(this.dbName);
           return db.getCollection(collectionName, clazz);
    
    }
    
    
    
}
