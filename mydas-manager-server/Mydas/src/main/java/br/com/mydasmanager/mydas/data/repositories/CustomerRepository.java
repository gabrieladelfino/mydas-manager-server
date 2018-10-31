package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import br.com.mydasmanager.mydas.data.statements.CustomerStatements;
import br.com.mydasmanager.mydas.model.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRepository extends CustomerStatements{
    
    public boolean insertDeviceInformation(CustomerModel customer) {

        try {
            
            Connection conn = new ConnectionStatements().getConnection();
            PreparedStatement pstm = conn.prepareStatement(SELECT_CUSTOMER);

            pstm.setString(1, customer.getUserName());
          
            pstm.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    } 

}
