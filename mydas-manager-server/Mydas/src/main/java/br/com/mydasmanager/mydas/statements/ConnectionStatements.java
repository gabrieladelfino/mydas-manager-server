package br.com.mydasmanager.mydas.statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionStatements {

    public static Connection StartConnection(){
        String connectionUrl = "jdbc:sqlserver://mydasmanager.database.windows.net:1433;database=db.mydas.manager;user=mydas.manager@mydasmanager;password={Digital@2018};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

        try (Connection con = DriverManager.getConnection(connectionUrl);) {
            return DriverManager.getConnection(connectionUrl);        
        }
        catch (SQLException e) {
            e.getStackTrace();
        }
        
        return null;
    }
}
