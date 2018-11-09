package br.com.mydasmanager.mydas.data;

import br.com.mydasmanager.mydas.model.DeviceModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeviceRepository {

    public static void insert(DeviceModel device) {

        try {

            PreparedStatement pstm = ConnectionStatements.getConnection()
                    .prepareStatement(DeviceStatements.INSERT_CUSTOMER_DEVICE);

            pstm.setString(1, device.getNameUser());
            pstm.setInt(2, device.getCustomerId());

            pstm.execute();

            System.out.println("Device: executou");

        } catch (SQLException e) {
            System.err.println("Device: " + e.getMessage());
        }
    }

    public static int selectMaxDeviceId() {

        try {
            Statement statement = ConnectionStatements.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(DeviceStatements.SELECT_MAX_CUSTOMER_DEVICE_ID);

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
