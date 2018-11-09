package br.com.mydasmanager.mydas.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRepository {

    public static int selectMaxDeviceId() {

        try {
            Statement statement = ConnectionStatements.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(CustomerStatements.SELECT_MAX_CUSTOMER_ID);

            while (rs.next()) {
                return rs.getInt(1);
            }

            System.out.println("Customer: executou");

        } catch (SQLException e) {
            System.err.println("Customer: " + e.getMessage());
        }

        return 0;
    }
}
