/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productosdb_pojos.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Roberto
 */
public class MongoConfig {
    private MongoConfig(){
    
    }
    
    public static MongoClientSettings buildSettings(String uri){
        ConnectionString conn = new ConnectionString(uri);
        
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), 
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        return MongoClientSettings.builder().applyConnectionString(conn).codecRegistry(pojoCodecRegistry).build();
    }
}
