package br.com.mydasmanager.mydas.data.repository;

import br.com.mydasmanager.mydas.data.CustomerDeviceStatements;
import br.com.mydasmanager.mydas.data.MainConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDeviceRepository {

    public static int selectMaxCustomerDeviceId() {

        ResultSet rs = MainConnection.executeResult(CustomerDeviceStatements.SELECT_MAX_CUSTOMER_DEVICE_ID);

        try {
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }
}
