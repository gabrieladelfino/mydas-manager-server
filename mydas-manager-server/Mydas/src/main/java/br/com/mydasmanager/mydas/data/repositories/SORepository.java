package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.model.SOModel;
import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import br.com.mydasmanager.mydas.data.statements.SOStatements;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SORepository extends SOStatements {

    Connection conn = new ConnectionStatements().getConnection();
    int deviceid = 0;

    public boolean insertSOInformation(SOModel so) {

        try {

            PreparedStatement pstm = conn.prepareStatement(INSERT_SO);

            pstm.setString(1, so.getNameSystem());
            pstm.setString(2, so.getNameUser());
            pstm.setString(3, so.getSystemVersion());
            pstm.setDate(4, so.getDateCapture());
            pstm.setInt(5, so.getDeviceId());

            pstm.execute();

            System.out.println("Executou.");

            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    public int selectDeviceId(int customerid) {
        try {

            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery(SELECT_CUSTOMER_DEVICE_ID);

            while (rs.next()) {
                deviceid = rs.getInt("id");
            }

            return deviceid;
        } catch (Exception ex) {
            ex.getStackTrace();
        }

        return 0;
    }

}
