package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.model.DeviceModel;
import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import br.com.mydasmanager.mydas.data.statements.DeviceStatements;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeviceRepository extends DeviceStatements {
    
    public boolean insertDeviceInformation(DeviceModel device) {

        try {
            
            Connection conn = new ConnectionStatements().getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT_CUSTOMER_DEVICE);

            pstm.setString(1, device.getNameUser());
            pstm.setInt(2, device.getCustomerId());

            pstm.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    } 
}
