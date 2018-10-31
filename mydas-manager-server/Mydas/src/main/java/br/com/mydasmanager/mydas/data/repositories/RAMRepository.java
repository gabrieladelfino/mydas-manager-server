package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.model.RAMModel;
import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import br.com.mydasmanager.mydas.data.statements.RAMStatements;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RAMRepository extends RAMStatements{

    public boolean insertRAMInformation(RAMModel ram) {

        try {

            Connection conn = new ConnectionStatements().getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT_RAM);

            pstm.setDouble(1, ram.getTotalmemory());
            pstm.setDouble(2, ram.getFreememory());
            pstm.setDate(3, ram.getDateCapture());
            pstm.setInt(4, ram.getDeviceId());

            pstm.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

}
