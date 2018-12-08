package br.com.mydasmanager.data.repository;

import br.com.mydasmanager.data.GPUStatements;
import br.com.mydasmanager.controller.CaptureDate;
import br.com.mydasmanager.controller.EstruturalLog;
import br.com.mydasmanager.model.GPUModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GPURepository {

    public static void insert(GPUModel gpu, int id) {

        PreparedStatement pstm = MainConnection.excutePrepared(GPUStatements.INSERT_GPU);
        
        try {
            pstm.setDouble(1, gpu.getTemperature());
            pstm.setString(2, gpu.getGpuName());
            pstm.setDouble(3, gpu.getFan());
            pstm.setInt(4, id);
            pstm.setString(5, CaptureDate.selectDate());

            pstm.execute();
        } catch (SQLException ex) {
            EstruturalLog.log("ERROR", ex.getMessage(), ex.getClass().getName());
        }
    }
}
