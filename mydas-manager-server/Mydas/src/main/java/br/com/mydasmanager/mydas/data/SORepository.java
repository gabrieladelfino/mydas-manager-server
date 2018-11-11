package br.com.mydasmanager.mydas.data;

import br.com.mydasmanager.mydas.model.CaptureDate;
import br.com.mydasmanager.mydas.model.SOModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SORepository {

    int deviceid = 0;

    public static boolean insert(SOModel so) {

        try {

            PreparedStatement pstm = MainConnection.excutePrepared(SOStatements.INSERT_SO);

            pstm.setString(1, so.getNameSystem());
            pstm.setString(2, so.getNameUser());
            pstm.setString(3, so.getSystemVersion());
            pstm.setString(4, CaptureDate.selectDate());
            pstm.setInt(5, so.getDeviceId());

            pstm.execute();

            System.out.println("SO: Executou.");
            return true;

        } catch (SQLException e) {
            System.err.println("SO: "+e.getMessage());
        }

        return false;
    }
}
