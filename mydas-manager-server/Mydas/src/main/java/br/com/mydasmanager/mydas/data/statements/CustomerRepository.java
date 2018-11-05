package br.com.mydasmanager.mydas.data.statements;

import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import br.com.mydasmanager.mydas.data.statements.CustomerStatements;
import br.com.mydasmanager.mydas.model.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository {

    Connection conn = new ConnectionStatements().getConnection();
    int customerId = 0;

    public int selectCustomerId(CustomerModel customer) {

        try {

            PreparedStatement pstm = conn.prepareStatement(CustomerStatements.SELECT_CUSTOMER);
            pstm.setString(1, customer.getUserName());

            ResultSet rs = pstm.executeQuery();

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
