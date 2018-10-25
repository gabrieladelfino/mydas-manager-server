package br.com.mydasmanager.mydas.data.repositories;

import br.com.mydasmanager.mydas.model.DeviceModel;
import br.com.mydasmanager.mydas.model.SOModel;
import br.com.mydasmanager.mydas.data.statements.ConnectionStatements;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SORepository {
   
    Connection conn = new ConnectionStatements().getConnection();
    
    public boolean insertSOInformation(SOModel so) {

        try {
        
            String sql = "INSERT INTO so("
                   + "  namesystem "
                   + ", systemversion "
                   + ", nameuser"
                   + ", datecapture"
                   + ", deviceid)"
                   + "VALUES (?, ?, ?, ?, ?)";
      
            PreparedStatement pstm = conn.prepareStatement(sql);
                    
            pstm.setString(1, so.getNameSystem());
            pstm.setString(2, so.getNameUser());
            pstm.setString(3, so.getSystemVersion());
            pstm.setDate(4, so.getDateCapture());
            pstm.setInt(4, so.getDeviceid());
            
            pstm.execute();
            
            System.out.println("Executou!");
            
            return true;
            
       } catch (Exception e) {
            System.err.println(e.getMessage());
       }
        
        return false;
    }
    
    public int selectDeviceId(int customerid){
        try {
            int deviceid = 0;
            Statement stmt = conn.createStatement();
            ResultSet rs;
        
            rs = stmt.executeQuery("SELECT id FROM customer_device WHERE customer_id "+customerid);
            
            while (rs.next()) {
               deviceid = rs.getInt("id");
            }
            
            return deviceid;
        }catch(Exception ex){
            ex.getStackTrace();
        }
        
        return 0;
    }
    
}
