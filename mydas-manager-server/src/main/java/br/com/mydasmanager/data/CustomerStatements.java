/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mydasmanager.data;

/**
 *
 * @author Gabriela Garcia
 */
public class CustomerStatements {
    
    public static final String SELECT_LOGIN = "SELECT * FROM customer WHERE email = ? AND password = ?";
    public static final String SELECT_CODE_ACESS = "SELECT * FROM customer WHERE codeacess = ?";
    
}
