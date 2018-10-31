package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import br.com.mydasmanager.mydas.data.statements.CustomerStatements;
import br.com.mydasmanager.mydas.model.CustomerModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRepository extends CustomerStatements {

    Connection conn = new ConnectionStatements().getConnection();
    int customerId = 0;

    public int selectCustomerId(CustomerModel customer) {

        try {

            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery(SELECT_CUSTOMER);

            while (rs.next()) {
                customerId = rs.getInt("id");
            }
            
            return customerId;

        } catch (SQLException ex) {
            ex.getStackTrace();

        }

        return 0;
    }
}
