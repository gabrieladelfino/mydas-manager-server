package br.com.mydasmanager.data.repository;

import br.com.mydasmanager.data.MainConnection;
import br.com.mydasmanager.data.RAMStatements;
import br.com.mydasmanager.controller.CaptureDate;
import br.com.mydasmanager.model.RAMModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RAMRepository {

    public static void insert(RAMModel ram, int id) {

        PreparedStatement pstm = MainConnection.excutePrepared(RAMStatements.INSERT_RAM);

        try {

            pstm.setDouble(1, ram.getTotalmemory());
            pstm.setDouble(2, ram.getFreememory());
            pstm.setString(3, CaptureDate.selectDate());
            pstm.setInt(4, id);
            pstm.setDouble(5, ram.getCurrentMemoryUse());

            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RAMRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Double> selectFreeMemory(int id) {

        List<Double> data = new ArrayList();

        try {
            PreparedStatement pstm = MainConnection.excutePrepared(RAMStatements.SELECT_FREE_MEMORY);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                data.add(rs.getDouble("freememory"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RAMRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }
}
