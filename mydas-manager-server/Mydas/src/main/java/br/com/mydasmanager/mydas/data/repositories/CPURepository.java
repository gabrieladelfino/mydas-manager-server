package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.data.statements.CPUStatements;
import br.com.mydasmanager.mydas.model.CPUModel;
import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CPURepository {

    public static boolean insertCPUInformation(CPUModel cpu) {
        try {

            Connection conn = new ConnectionStatements().getConnection();
            PreparedStatement pstm = conn.prepareStatement(CPUStatements.INSERT_CPU);

            pstm.setString(1, cpu.getModel());
            pstm.setString(2, cpu.getGhz());
            pstm.setString(3, cpu.getProcessorName());
            pstm.setInt(4, cpu.getCore());
            pstm.setString(5, cpu.getCurrentUse());
            pstm.setLong(6, cpu.getFrequency());
            pstm.setDouble(7, cpu.getTemperature());
            pstm.setInt(8, cpu.getDeviceId());
            pstm.setDate(9, cpu.getDateCapture());

            pstm.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }
}
