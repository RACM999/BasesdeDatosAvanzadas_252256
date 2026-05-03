/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnup.dao.exception;

/**
 *
 * @author Roberto
 */
public class EntidadNoEncontradaException extends RuntimeException {

    public EntidadNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}