package br.com.mydasmanager.mydas.data;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriela Garcia
 */
public class DeviceRepository {

    public static int setInterval() {

        ResultSet rs = MainConnection.executeResult(DeviceStatements.SELECT_INTERVAL_CAPTURE);
        
        try {
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
