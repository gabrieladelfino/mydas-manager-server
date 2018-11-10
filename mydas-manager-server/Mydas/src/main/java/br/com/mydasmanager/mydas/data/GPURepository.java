package br.com.mydasmanager.mydas.data;

import br.com.mydasmanager.mydas.model.CaptureDate;
import br.com.mydasmanager.mydas.model.GPUModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GPURepository {
    
    public static boolean insert(GPUModel gpu) {
        
        try {
            
            PreparedStatement pstm = ConnectionStatements.getConnection().prepareStatement(GPUStatements.INSERT_GPU);
            pstm.setDouble(1, gpu.getTemperature());
            pstm.setString(2, gpu.getGpuName());
            pstm.setDouble(3, gpu.getFan());
            pstm.setInt(4, gpu.getDeviceId());
            pstm.setString(5, CaptureDate.selectDate());
                    
            pstm.execute();

            System.out.println("GPU: Executou.");
            return true;

        } catch (SQLException e) {
            System.err.println("GPU: "+e.getMessage());
        }

        return false;
    }

    
}
