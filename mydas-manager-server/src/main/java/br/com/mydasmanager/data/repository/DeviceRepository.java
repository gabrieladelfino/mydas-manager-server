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
//
//    PreparedStatement stmt = con.prepareStatement(sql);   
//stmt.setString(1, nome);
//ResultSet rs = stmt.executeQuery(sql);

    public static int selectInterval(int id) {
        try {
            PreparedStatement pstm = MainConnection.excutePrepared(DeviceStatements.SELECT_INTERVAL_CAPTURE);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                return rs.getInt("interval");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public static int selectIsRunning(int id) {
        try {
            PreparedStatement pstm = MainConnection.excutePrepared(DeviceStatements.SELECT_IS_RUNNING);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("status");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }
}
