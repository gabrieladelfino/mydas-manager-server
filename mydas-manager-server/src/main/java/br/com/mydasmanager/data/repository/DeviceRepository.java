package br.com.mydasmanager.data.repository;

import br.com.mydasmanager.data.DeviceStatements;
import br.com.mydasmanager.data.MainConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriela Garcia
 */
public class DeviceRepository {

    public static int selectInterval(int id) {
        try {
            PreparedStatement rs = MainConnection.excutePrepared(DeviceStatements.SELECT_INTERVAL_CAPTURE);
            rs.setInt(1, id);
            return rs.getResultSet().getInt("interval");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public static int selectIsRunning(int id) {
        try {
            PreparedStatement rs = MainConnection.excutePrepared(DeviceStatements.SELECT_IS_RUNNING);
            rs.setInt(1, id);
            return rs.getResultSet().getInt("isrunning");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }
}
