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
            pstm.setDouble(4, gpu.getFan());
            pstm.setInt(5, gpu.getDeviceId());
            pstm.setDate(6, gpu.getDateCapture());
                    
            pstm.execute();

            return true;

        } catch (SQLException e) {
            System.err.println("GPU: "+e.getMessage());
        }

        return false;
    }

    
}
