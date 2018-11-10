package br.com.mydasmanager.mydas.data;

import br.com.mydasmanager.mydas.model.CaptureDate;
import br.com.mydasmanager.mydas.model.GPUModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GPURepository {

    static final Logger LOGGER = LoggerFactory.getLogger(GPURepository.class);

    public static void insert(GPUModel gpu) {

        try {

            PreparedStatement pstm = ConnectionStatements.getConnection().prepareStatement(GPUStatements.INSERT_GPU);
            pstm.setDouble(1, gpu.getTemperature());
            pstm.setString(2, gpu.getGpuName());
            pstm.setDouble(3, gpu.getFan());
            pstm.setInt(4, gpu.getDeviceId());
            pstm.setString(5, CaptureDate.selectDate());

            pstm.execute();

            LOGGER.info("Insert de CPU executado");
        } catch (SQLException e) {
            LOGGER.error("Erro - " + e.getMessage());
        }
    }

}
