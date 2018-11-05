package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.model.DeviceModel;
import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import br.com.mydasmanager.mydas.data.statements.DeviceStatements;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeviceRepository {

    public static boolean insert(DeviceModel device) {

        try {

            PreparedStatement pstm = ConnectionStatements.getConnection()
                    .prepareStatement(DeviceStatements.INSERT_CUSTOMER_DEVICE);

            pstm.setString(1, device.getNameUser());
            pstm.setInt(2, device.getCustomerId());

            pstm.execute();

            System.out.println("Device: executou");
            return true;

        } catch (SQLException e) {
            System.err.println("Device: "+e.getMessage());
        }

        return false;
    }
}
