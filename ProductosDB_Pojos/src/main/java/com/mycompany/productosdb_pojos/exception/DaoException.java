/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productosdb_pojos.exception;

/**
 *
 * @author Roberto
 */
public class DaoException extends RuntimeException{
    public DaoException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
