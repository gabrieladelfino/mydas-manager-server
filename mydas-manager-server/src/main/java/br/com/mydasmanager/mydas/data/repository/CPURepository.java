package br.com.mydasmanager.mydas.data.repository;

import br.com.mydasmanager.mydas.data.CPUStatements;
import br.com.mydasmanager.mydas.data.MainConnection;
import br.com.mydasmanager.mydas.model.CPUModel;
import br.com.mydasmanager.mydas.controller.CaptureDate;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CPURepository {

    public static void insert(CPUModel cpu) {

        try {
            PreparedStatement pstm = MainConnection.excutePrepared(CPUStatements.INSERT_CPU);
            
            pstm.setString(1, cpu.getModel());
            pstm.setString(2, cpu.getGhz());
            pstm.setInt(3, cpu.getCore());
            pstm.setString(4, cpu.getCurrentUse());
            pstm.setString(5, cpu.getTemperature());
            pstm.setInt(6, cpu.getDeviceId());
            pstm.setString(7, CaptureDate.selectDate());
            
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CPURepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
