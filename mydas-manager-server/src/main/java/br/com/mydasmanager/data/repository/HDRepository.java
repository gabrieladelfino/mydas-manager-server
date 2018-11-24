package br.com.mydasmanager.data.repository;

import br.com.mydasmanager.data.HDStatements;
import br.com.mydasmanager.data.MainConnection;
import br.com.mydasmanager.model.HDModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriela Garcia
 */
public class HDRepository {

    public static void insert(HDModel hd, int id) {

        PreparedStatement pstm = MainConnection.excutePrepared(HDStatements.INSERT_HD);

        try {
            pstm.setDouble(1, hd.getBytesRead());
            pstm.setDouble(2, hd.getBytesWritten());
            pstm.setInt(3, id);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HDRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static List<Double> selectBytesRead(int id) {

        List<Double> data = new ArrayList();

        try {
            PreparedStatement pstm = MainConnection.excutePrepared(HDStatements.SELECT_BYTES_READ);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                data.add(rs.getDouble(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RAMRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }
}
