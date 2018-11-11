package br.com.mydasmanager.mydas.data.repository;

import br.com.mydasmanager.mydas.data.MainConnection;
import br.com.mydasmanager.mydas.data.RAMStatements;
import br.com.mydasmanager.mydas.controller.CaptureDate;
import br.com.mydasmanager.mydas.model.RAMModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RAMRepository {

    public static void insert(RAMModel ram) {

        PreparedStatement pstm = MainConnection.excutePrepared(RAMStatements.INSERT_RAM);
        
        try {

            pstm.setDouble(1, ram.getTotalmemory());
            pstm.setDouble(2, ram.getFreememory());
            pstm.setString(3, CaptureDate.selectDate());
            pstm.setInt(4, ram.getDeviceId());
            pstm.setDouble(5, ram.getCurrentMemoryUse());

            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
