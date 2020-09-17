/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.escola.exception;

/**
 *
 * @author Delon
 */
public class NotConnectionException extends Exception {

    public NotConnectionException() {
        super(" Não foi possivel conectar no banco");
    }
    
}
