package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import br.com.mydasmanager.mydas.data.statements.GPUStatements;
import br.com.mydasmanager.mydas.model.GPUModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GPURepository {
    
    public static boolean insert(GPUModel gpu) {

        try {
            
            PreparedStatement pstm = ConnectionStatements.getConnection().prepareStatement(GPUStatements.INSERT_GPU);

            pstm.setDouble(1, gpu.getTemperature());
            pstm.setString(2, gpu.getGpuName());
            pstm.setDate(4, gpu.getDateCapture());
            pstm.setInt(5, gpu.getDeviceId());
            pstm.setDouble(6, gpu.getFan());
                    
            pstm.execute();

            return true;

        } catch (SQLException e) {
            System.err.println("GPU: "+e.getMessage());
        }

        return false;
    }

    
}
