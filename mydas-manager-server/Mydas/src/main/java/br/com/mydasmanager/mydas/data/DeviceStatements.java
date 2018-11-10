/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mydasmanager.mydas.data;

/**
 *
 * @author Gabriela Garcia
 */
public class DeviceStatements {
    
    public static final String SELECT_INTERVAL_CAPTURE = "select interval from device where id = "
            + "(select max(deviceid) from customer_device)";
    
}
