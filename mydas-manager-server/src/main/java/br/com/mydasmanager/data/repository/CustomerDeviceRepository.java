package br.com.mydasmanager.data.repository;

import br.com.mydasmanager.data.CustomerDeviceStatements;
import br.com.mydasmanager.data.MainConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDeviceRepository {

    public static int selectCustomerDeviceId(int customerid, int deviceid) {

        try {
            PreparedStatement pstm = MainConnection.excutePrepared(CustomerDeviceStatements.SELECT_CUSTOMER_DEVICE_ID);
            pstm.setInt(1, customerid);
            pstm.setInt(2, deviceid);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }
}
