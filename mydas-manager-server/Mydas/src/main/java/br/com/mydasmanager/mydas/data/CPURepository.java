package br.com.mydasmanager.mydas.data;

import br.com.mydasmanager.mydas.model.CPUModel;
import br.com.mydasmanager.mydas.model.CaptureDate;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CPURepository {

    public static boolean insert(CPUModel cpu) {
        try {

            PreparedStatement pstm = ConnectionStatements.getConnection().prepareStatement(CPUStatements.INSERT_CPU);

            pstm.setString(1, cpu.getModel());
            pstm.setString(2, cpu.getGhz());
            pstm.setString(3, cpu.getProcessorName());
            pstm.setInt(4, cpu.getCore());
            pstm.setDouble(5, cpu.getCurrentUse());
            pstm.setLong(6, cpu.getFrequency());
            pstm.setDouble(7, cpu.getTemperature());
            pstm.setInt(8, cpu.getDeviceId());
            pstm.setString(9, CaptureDate.selectDate());

            pstm.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }
}
