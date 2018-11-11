package br.com.mydasmanager.mydas.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDeviceRepository {

    public static int selectMaxCustomerDeviceId() throws SQLException {

        ResultSet rs = MainConnection.executeResult(CustomerDeviceStatements.SELECT_MAX_CUSTOMER_DEVICE_ID);

        if (rs != null) {

            while (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
    
    public static int selectInterval() throws SQLException {

        ResultSet rs = MainConnection.executeResult(CustomerDeviceStatements.SELECT_INTERVAL);
        
        if (rs != null) {

            while (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;

    }
}
