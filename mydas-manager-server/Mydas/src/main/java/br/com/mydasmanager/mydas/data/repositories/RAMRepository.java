package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.model.RAMModel;
import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RAMRepository {

    public boolean insertRAMInformation(RAMModel ram) {

        try {

            String sql = "INSERT INTO ram("
                    + "  totalmemory"
                    + ", freememory"
                    + ", datecapture"
                    + ", deviceid)"
                    + "VALUES (?, ?, ?, ?)";

            Connection conn = new ConnectionStatements().getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setDouble(1, ram.getTotalmemory());
            pstm.setDouble(2, ram.getFreememory());
            pstm.setDate(3, ram.getDateCapture());
            pstm.setInt(4, ram.getDeviceid());

            pstm.execute();

            return true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

}
