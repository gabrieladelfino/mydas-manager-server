package br.com.mydasmanager.mydas.data.repository;

import br.com.mydasmanager.mydas.data.DeviceStatements;
import br.com.mydasmanager.mydas.data.MainConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriela Garcia
 */
public class DeviceRepository {

    public static int selectInterval()  {

        ResultSet rs = MainConnection.executeResult(DeviceStatements.SELECT_INTERVAL_CAPTURE);

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
