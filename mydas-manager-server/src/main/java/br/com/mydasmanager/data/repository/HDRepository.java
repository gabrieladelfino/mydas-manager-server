package br.com.mydasmanager.data.repository;

import br.com.mydasmanager.data.HDStatements;
import br.com.mydasmanager.data.MainConnection;
import br.com.mydasmanager.model.HDModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriela Garcia
 */
public class HDRepository {

    public static void insert(HDModel hd) {
        
        PreparedStatement pstm = MainConnection.excutePrepared(HDStatements.INSERT_HD);
        
        try {
            pstm.setDouble(1, hd.getBytesRead());
            pstm.setDouble(2, hd.getBytesWritten());
            pstm.setInt(3, hd.getDeviceId());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HDRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
