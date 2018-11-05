package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.model.RAMModel;
import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import br.com.mydasmanager.mydas.data.statements.RAMStatements;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RAMRepository {

    public static boolean insert(RAMModel ram) {

        try {

           PreparedStatement pstm = ConnectionStatements.getConnection().prepareStatement(RAMStatements.INSERT_RAM);

            pstm.setDouble(1, ram.getTotalmemory());
            pstm.setDouble(2, ram.getFreememory());
            pstm.setDate(3, ram.getDateCapture());
            pstm.setInt(4, ram.getDeviceId());

            pstm.execute();

            return true;

        } catch (SQLException e) {
            System.err.println("RAM: "+e.getMessage());
        }

        return false;
    }

}
