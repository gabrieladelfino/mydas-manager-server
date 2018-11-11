package br.com.mydasmanager.mydas.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDeviceRepository {

    public static int selectMaxCustomerDeviceId() {

        ResultSet rs = MainConnection.executeResult(CustomerDeviceStatements.SELECT_MAX_CUSTOMER_DEVICE_ID);

        try {
            
            while (rs.next()) {
                return rs.getInt(1);
            }

            System.out.println("CustomerDevice: executou");

        } catch (SQLException e) {
            System.err.println("CustomerDevice: " + e.getMessage());
        }

        return 0;
    }
}
