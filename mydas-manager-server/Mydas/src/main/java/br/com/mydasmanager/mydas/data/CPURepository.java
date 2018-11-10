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
            pstm.setInt(3, cpu.getCore());
            pstm.setString(4, cpu.getCurrentUse());
            pstm.setString(5, cpu.getTemperature());
            pstm.setInt(6, cpu.getDeviceId());
            pstm.setString(7, CaptureDate.selectDate());

            pstm.execute();
            System.out.println("CPU: Executou.");
            return true;

        } catch (SQLException e) {
            System.err.println("CPU: "+e.getMessage());
        }

        return false;
    }
}
