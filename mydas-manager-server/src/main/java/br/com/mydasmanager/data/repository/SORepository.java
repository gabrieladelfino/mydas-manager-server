package br.com.mydasmanager.data.repository;

import br.com.mydasmanager.data.SOStatements;
import br.com.mydasmanager.controller.CaptureDate;
import br.com.mydasmanager.controller.EstruturalLog;
import br.com.mydasmanager.model.SOModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SORepository {

    public static void insert(SOModel so, int id) {

        PreparedStatement pstm = MainConnection.excutePrepared(SOStatements.INSERT_SO);

        try {
            pstm.setString(1, so.getNameSystem());
            pstm.setString(2, so.getNameUser());
            pstm.setString(3, so.getSystemVersion());
            pstm.setString(4, CaptureDate.selectDate());
            pstm.setInt(5, id);

            pstm.execute();
        } catch (SQLException ex) {
            EstruturalLog.log("ERROR", ex.getMessage(), ex.getClass().getName());
        }

    }
}
