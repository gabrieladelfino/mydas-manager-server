package br.com.mydasmanager.mydas.data;

import br.com.mydasmanager.mydas.model.CaptureDate;
import br.com.mydasmanager.mydas.model.RAMModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RAMRepository {

    public static void insert(RAMModel ram) throws SQLException {

        PreparedStatement pstm = MainConnection.excutePrepared(RAMStatements.INSERT_RAM);

        pstm.setDouble(1, ram.getTotalmemory());
        pstm.setDouble(2, ram.getFreememory());
        pstm.setString(3, CaptureDate.selectDate());
        pstm.setInt(4, ram.getDeviceId());
        pstm.setDouble(5, ram.getCurrentMemoryUse());

        pstm.execute();
    }
}
