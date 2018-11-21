package br.com.mydasmanager.data.repository;

import br.com.mydasmanager.data.DeviceStatements;
import br.com.mydasmanager.data.MainConnection;
import br.com.mydasmanager.model.DeviceModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriela Garcia
 */
public class DeviceRepository {

    public static int selectInterval(int id) {
        try {
            PreparedStatement pstm = MainConnection.excutePrepared(DeviceStatements.SELECT_INTERVAL_CAPTURE);
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                return rs.getInt("interval");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public static int selectDeviceId(int customerid) {
        try {

            PreparedStatement pstm = MainConnection.excutePrepared(DeviceStatements.SELECT_ID);
            pstm.setInt(1, customerid);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public static List<DeviceModel> selectDevices(int id) {

        List<DeviceModel> data = new ArrayList();
        DeviceModel device;

        try {
            PreparedStatement pstm = MainConnection.excutePrepared(DeviceStatements.SELECT_DEVICES);
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                device = new DeviceModel();
                device.setMachineName(rs.getString("machinename"));
                device.setId(rs.getInt("id"));
                data.add(device);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }
}
