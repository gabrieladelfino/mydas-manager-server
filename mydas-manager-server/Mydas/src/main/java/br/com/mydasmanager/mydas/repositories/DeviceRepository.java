package br.com.mydasmanager.mydas.repositories;

import br.com.mydasmanager.mydas.model.DeviceInformation;
import br.com.mydasmanager.mydas.statements.ConnectionStatements;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeviceRepository {
    
    public boolean insertDeviceInformation(DeviceInformation device) {

        try {

            String sql = "INSERT INTO customer_device("
                    + "useractive)"
                    + "VALUES (?)";

            Connection conn = new ConnectionStatements().getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, device.getNameUser());

            pstm.execute();

            return true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return false;
    } 
}
