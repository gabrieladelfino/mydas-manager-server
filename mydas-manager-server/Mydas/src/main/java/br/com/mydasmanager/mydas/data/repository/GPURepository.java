package br.com.mydasmanager.mydas.data;

import br.com.mydasmanager.mydas.model.CaptureDate;
import br.com.mydasmanager.mydas.model.GPUModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GPURepository {

    public static void insert(GPUModel gpu) {

        PreparedStatement pstm = MainConnection.excutePrepared(GPUStatements.INSERT_GPU);
        
        try {
            pstm.setDouble(1, gpu.getTemperature());
            pstm.setString(2, gpu.getGpuName());
            pstm.setDouble(3, gpu.getFan());
            pstm.setInt(4, gpu.getDeviceId());
            pstm.setString(5, CaptureDate.selectDate());

            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
