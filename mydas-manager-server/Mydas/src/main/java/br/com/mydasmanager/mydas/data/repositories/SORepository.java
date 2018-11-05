package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.model.SOModel;
import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import br.com.mydasmanager.mydas.data.statements.SOStatements;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SORepository {

    int deviceid = 0;

    public static boolean insert(SOModel so) {

        try {

            PreparedStatement pstm = ConnectionStatements.getConnection().prepareStatement(SOStatements.INSERT_SO);

            pstm.setString(1, so.getNameSystem());
            pstm.setString(2, so.getNameUser());
            pstm.setString(3, so.getSystemVersion());
            pstm.setDate(4, so.getDateCapture());
            pstm.setInt(5, so.getDeviceId());

            pstm.execute();

            return true;

        } catch (SQLException e) {
            System.err.println("SO: "+e.getMessage());
        }

        return false;
    }

    public int selectDeviceId(int customerid) {
        try {

            Statement stmt = ConnectionStatements.getConnection().createStatement();
            ResultSet rs;

            rs = stmt.executeQuery(SOStatements.SELECT_CUSTOMER_DEVICE_ID);

            while (rs.next()) {
                deviceid = rs.getInt("id");
            }

            return deviceid;
        } catch (SQLException ex) {
            ex.getStackTrace();
        }

        return 0;
    }

}
