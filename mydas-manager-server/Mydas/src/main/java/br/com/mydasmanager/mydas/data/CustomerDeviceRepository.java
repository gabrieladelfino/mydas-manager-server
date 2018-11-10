package br.com.mydasmanager.mydas.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDeviceRepository {

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
