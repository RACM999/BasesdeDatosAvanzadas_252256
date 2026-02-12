/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package com.mycompany.miprimeraconexionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Roberto Cortez
 */
public class MiPrimeraConexionJDBC {
    
    private static final String URL = "jdbc:mysql://localhost:3306/MyDataBase";
    private static final String USER = "root";
    private static final String PASS = "ITSON";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASS);
    }

    public static void crearTabla() throws SQLException{
        String sql = "CREATE TABLE IF NOT EXISTS clientes ("  
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "nombre VARCHAR(100),"
                + "password VARCHAR(100))";
        
        try(
            Connection con = getConnection();
            Statement st = con.createStatement();){
            st.execute(sql);
            System.out.println("Tabla creada");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static boolean login(String nombre, String pass) throws SQLException{
        String sql = "SELECT * FROM clientes WHERE nombre = '" + nombre + "' AND password = '" + pass + "'";
        
        try(Connection con = getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
            )
        {
            return rs.next();
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean loginSeguro(String nombre, String password) throws SQLException{
        String sql = "SELECT * FROM clientes WHERE nombre = ? AND password = ?";
        
        try(
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
           ){
            ps.setString(1, nombre);
            ps.setString(2, password);
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static void obtenerClientes() throws SQLException{
        String sql = "SELECT * FROM clientes";
        
        try(
                Connection con = getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
           )
        {
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                
                System.out.println(id + "-" + nombre);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void insertar(String nombre, String password) throws SQLException{
        String sql = "INSERT INTO clientes (nombre, password) VALUES(?, ?)";
        try(
            Connection con = getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
           ){
            ps.setString(1, nombre);
            ps.setString(2, password);
            
            int filas = ps.executeUpdate();
            
            if(filas > 0){
                try(ResultSet rs = ps.getGeneratedKeys()){
                    while(rs.next()){
                        System.out.println("Insertado cliente con ID "+rs.getInt(1));
                    }
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void obtenerClientePorID(int id) throws SQLException{
        String sql = "SELECT id, nombre, password FROM clientes WHERE id = ?";
        try(
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
           ){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    System.out.println("ID: " +rs.getInt("id")
                    + ", Nombre: " + rs.getString("nombre")
                    + ", Password: " + rs.getString("password"));
                }
                else {
                    System.out.println("No se encontró cliente con el ID: "+id);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void actualizar(int id, String nuevoNombre, String nuevoPassword) throws SQLException{
        String sql = "UPDATE clientes SET nombre = ?, password = ? WHERE id = ?";
        try(
            Connection con = getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql)
           ){
            ps.setString(1, nuevoNombre);
            ps.setString(2, nuevoPassword);
            ps.setInt(3, id);
            
            int filas = ps.executeUpdate();
            
            if (filas > 0 ){
                System.out.println("Cliente actualizado con ID: "+id);
            }else{
                System.out.println("No se encontró el cliente con ID");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }  
    }
    
    public static void eliminar(int id) throws SQLException{
        String sql = "DELETE FROM clientes WHERE id = ?";
        try(Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            
            if(filas > 0){
                System.out.println("Cliente eliminado con ID: "+id);
            }
            else{
                System.out.println("No se encontró al cliente con ID: "+id);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void truncarTabla(String tabla) throws SQLException{
        String sql = "TRUNCATE TABLE " + tabla;
        try(
            Connection con = getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql)
           ){
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        try{
            //tenia otros datos en la tabla guardados de antes
            truncarTabla("clientes");
            
            // crear tabla
            crearTabla();
            
            //insertar clientes de prueba
            insertar("Jesus","hola");
            insertar("Jorge","hello");
            insertar("Jeni","queso");
            insertar("Iram","3432");
            
            //leer todos los clientes
            System.out.println("\n--- Todos los clientes");
            obtenerClientes();
            
            //leer clientes por id
            System.out.println("Cliente con id 1: ");
            obtenerClientePorID(1);
            System.out.println("Cliente con id 2: ");
            obtenerClientePorID(2);
            System.out.println("Cliente con id 100:");
            obtenerClientePorID(100);
            
            //actualizar cliente
            System.out.println("\n --- Actualización ---");
            actualizar(1,"Jesus Antonio","adios");
            obtenerClientePorID(1);
            
            //eliminar cliente
            System.out.println("\n --- Eliminación ---");
            eliminar(4);
            obtenerClientes();
            
            //pruebas de login 
            System.out.println("\n --- Login normal ---");
            System.out.println("Login Jesus Antonio/Adios = " + login("Jesus Antonio","Adios"));
            System.out.println("Login Jorge/hello = " + login("Jorge","hello"));
            System.out.println("Login Jeni/queso = " + login("Jeni","queso"));
            
            //pruebas de login seguro
            System.out.println("\n --- Login seguro ---");
            System.out.println("Login Jesus Antonio/Adios = " + loginSeguro("Jesus Antonio","Adios"));
            System.out.println("Login Jorge/hello = " + loginSeguro("Jorge","hello"));
            System.out.println("Login Jeni/queso = " + loginSeguro("Jeni","queso"));
            
            //pruebas de inyeccion sql
            System.out.println("\n --- Prueba SQL Injection ---");
            System.out.println("Login Jesus Antonio/Adios = " + login("Jesus Antonio","' OR '1'='1"));
            System.out.println("Login Jorge/hello = " + loginSeguro("Jorge","' OR '1'='1"));
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}