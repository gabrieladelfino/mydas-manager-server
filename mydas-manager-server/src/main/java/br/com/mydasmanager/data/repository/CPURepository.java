package br.com.mydasmanager.data.repository;

import br.com.mydasmanager.data.CPUStatements;
import br.com.mydasmanager.model.CPUModel;
import br.com.mydasmanager.controller.CaptureDate;
import br.com.mydasmanager.controller.EstruturalLog;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CPURepository {

    public static void insert(CPUModel cpu, int id) {

        try {
            PreparedStatement pstm = MainConnection.excutePrepared(CPUStatements.INSERT_CPU);

            pstm.setString(1, cpu.getModel());
            pstm.setString(2, cpu.getGhz());
            pstm.setInt(3, cpu.getCore());
            pstm.setString(4, cpu.getCurrentUse());
            pstm.setString(5, cpu.getTemperature());
            pstm.setInt(6, id);
            pstm.setString(7, CaptureDate.selectDate());

            pstm.execute();
        } catch (SQLException ex) {
            EstruturalLog.log("ERROR", ex.getMessage(), "CPURepository_");
        }
    }
}
