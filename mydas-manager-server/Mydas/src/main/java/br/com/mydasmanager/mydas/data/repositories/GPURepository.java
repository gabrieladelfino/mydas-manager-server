package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import br.com.mydasmanager.mydas.data.statements.GPUStatements;
import br.com.mydasmanager.mydas.model.GPUModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GPURepository {
    
    public boolean insertGPU(GPUModel gpu) {

        try {

            Connection conn = new ConnectionStatements().getConnection();
            PreparedStatement pstm = conn.prepareStatement(GPUStatements.INSERT_GPU);

            pstm.setDouble(1, gpu.getTemperature());
            pstm.setString(2, gpu.getGpuName());
            pstm.setDate(4, gpu.getDateCapture());
            pstm.setInt(5, gpu.getDeviceId());
            pstm.setDouble(6, gpu.getFan());
                    
            pstm.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    
}
