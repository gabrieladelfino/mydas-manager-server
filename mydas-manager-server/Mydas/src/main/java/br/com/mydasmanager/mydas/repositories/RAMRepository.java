package br.com.mydasmanager.mydas.repositories;

import br.com.mydasmanager.mydas.model.RAM;
import br.com.mydasmanager.mydas.statements.ConnectionStatements;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RAMRepository {

    public boolean insertRAMInformation(RAM ram) {

        try {

            String sql = "INSERT INTO ram("
                    + "totalmemory, "
                    + "freememory)"
                    + "VALUES (?, ?)";

            Connection conn = new ConnectionStatements().getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setDouble(1, ram.getTotalmemory());
            pstm.setDouble(2, ram.getFreememory());

            pstm.execute();

            return true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

}
