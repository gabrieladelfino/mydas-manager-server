package br.com.mydasmanager.mydas.repositories;

import br.com.mydasmanager.mydas.model.SO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeviceRepository {
    
    public void cadastrar (SO so) {
        Connection conn = null;
        try {
            String sql = "INSERT INTO SO_information("
                    + "namesystem, "
                    + "systemversion, "
                    + "nameuser)"
                    + "VALUES (?, ?, ?)";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, so.getNameSystem());
            pstm.setString(2, so.getNameUser());
            pstm.setString(3, so.getSystemVersion());
            
            pstm.execute();
            
       } catch (Exception e) {
            System.err.println(e.getMessage());
       }
    }
}
