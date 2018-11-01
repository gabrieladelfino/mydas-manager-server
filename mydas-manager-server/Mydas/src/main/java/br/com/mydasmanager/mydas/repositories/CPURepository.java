package br.com.mydasmanager.mydas.repositories;

import br.com.mydasmanager.mydas.model.CPUModel;
import br.com.mydasmanager.mydas.statements.ConnectionStatements;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CPURepository {

    public boolean insertCPUInformation(CPUModel cpu) {
        try {

            String sql = "INSERT INTO cpu("
                    + "model, "
                    + "ghz,"
                    + "processorname, "
                    + "core, "
                    + "currentuse, "
                    + "frequency, "
                    + "temperature, "
                    + "customerdevice, "
                    + "datecapture)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Connection conn = new ConnectionStatements().getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, cpu.getModel());
            pstm.setString(2, cpu.getGhz());
            pstm.setString(3, cpu.getProcessorName());
            pstm.setInt(4, cpu.getCore());
            pstm.setString(5, cpu.getCurrentUse());
            pstm.setLong(6, cpu.getFrequency());
            pstm.setDouble(7, cpu.getTemperature());
            pstm.setString(8, cpu.getDeviceId());
            pstm.setString(9, cpu.getDateCapture());

            pstm.execute();

            System.out.println("Executou!");

            return true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return false;

    }

}
