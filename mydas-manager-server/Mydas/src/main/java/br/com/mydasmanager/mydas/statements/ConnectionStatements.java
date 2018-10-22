package br.com.mydasmanager.mydas.statements;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionStatements {
    
    final String _URL = "jdbc:sqlserver://mydasmanager.database.windows.net:1433;database=mydas-manager;"
                      + "user=mydas.manager@mydasmanager;password={Digital@2018};"
                      + "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;"
                      + "loginTimeout=30;";
    
            
     public Connection getConnection() {
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           System.out.println("Conectado");
           return DriverManager.getConnection(_URL);
        } 
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ou classe não encontrada: "+e.getMessage());
            return null;
        }
    }
     
    public static void closeConnection(Connection conn){
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
