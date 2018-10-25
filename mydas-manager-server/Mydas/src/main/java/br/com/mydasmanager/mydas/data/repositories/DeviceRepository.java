package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.model.DeviceModel;
import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeviceRepository {
    
    public boolean insertDeviceInformation(DeviceModel device) {

        try {

            String sql = "INSERT INTO customer_device("
                    + "  currentnameuser"
                    + ", customerid)"
                    + "VALUES (?, ?)";

            Connection conn = new ConnectionStatements().getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, device.getNameUser());
            pstm.setInt(2, device.getCustomerId());

            pstm.execute();

            return true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return false;
    } 
}
