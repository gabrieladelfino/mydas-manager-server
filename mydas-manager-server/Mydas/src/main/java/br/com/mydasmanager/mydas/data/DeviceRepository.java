/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mydasmanager.mydas.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabriela Garcia
 */
public class DeviceRepository {
     public static int selectMaxCustomerDeviceId() {

        try {
            Statement statement = ConnectionStatements.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(CustomerDeviceStatements.SELECT_MAX_CUSTOMER_DEVICE_ID);

            while (rs.next()) {
                return rs.getInt(1);
            }

            System.out.println("Device: executou");
      
        } catch (SQLException e) {
            System.err.println("Device: " + e.getMessage());
        }

        return 0;
    }
}
