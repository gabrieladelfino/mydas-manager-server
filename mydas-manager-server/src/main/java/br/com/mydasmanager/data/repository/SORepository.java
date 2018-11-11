package br.com.mydasmanager.data.repository;

import br.com.mydasmanager.data.MainConnection;
import br.com.mydasmanager.data.SOStatements;
import br.com.mydasmanager.controller.CaptureDate;
import br.com.mydasmanager.model.SOModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SORepository {

    public static void insert(SOModel so) {

        PreparedStatement pstm = MainConnection.excutePrepared(SOStatements.INSERT_SO);

        try {
            pstm.setString(1, so.getNameSystem());
            pstm.setString(2, so.getNameUser());
            pstm.setString(3, so.getSystemVersion());
            pstm.setString(4, CaptureDate.selectDate());
            pstm.setInt(5, so.getDeviceId());

            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
