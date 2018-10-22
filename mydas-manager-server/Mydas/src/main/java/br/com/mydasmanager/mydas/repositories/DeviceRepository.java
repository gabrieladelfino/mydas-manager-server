package br.com.mydasmanager.mydas.repositories;

import br.com.mydasmanager.mydas.model.SO;
import br.com.mydasmanager.mydas.statements.ConnectionStatements;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeviceRepository {
   
    
    public boolean insertSOInformation(SO so) {

        try {
        
            String sql = "INSERT INTO SO_infomation("
                   + "namesystem, "
                   + "systemversion, "
                   + "nameuser)"
                   + "VALUES (?, ?, ?)";
      
            Connection conn = new ConnectionStatements().getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
                    
            pstm.setString(1, so.getNameSystem());
            pstm.setString(2, so.getNameUser());
            pstm.setString(3, so.getSystemVersion());
            
            pstm.execute();
            
            System.out.println("Executou!");
            
            return true;
            
       } catch (Exception e) {
            System.err.println(e.getMessage());
       }
        
        return false;
    }
    
}
