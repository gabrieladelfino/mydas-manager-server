package br.com.mydasmanager.mydas.data;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriela Garcia
 */
public class DeviceRepository {

    public static int setInterval() throws SQLException {

        ResultSet rs = MainConnection.executeResult(DeviceStatements.SELECT_INTERVAL_CAPTURE);

        if (rs != null) {
            while (rs.next()) {
                return rs.getInt(1);
            }
        }

        return 0;
    }
}
