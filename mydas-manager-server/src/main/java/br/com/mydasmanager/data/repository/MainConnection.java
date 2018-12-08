package br.com.mydasmanager.data.repository;

import br.com.mydasmanager.controller.EstruturalLog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainConnection {

    public static Connection getConnection() {

        final String _URL = "jdbc:sqlserver://mydasmanager.database.windows.net:1433;database=mydas-manager;"
                + "user=mydas.manager@mydasmanager;password={Digital@2018};"
                + "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;"
                + "loginTimeout=30;";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            EstruturalLog.log("INFO", "Executou a operação.", MainConnection.class.getName());
            return DriverManager.getConnection(_URL);
        } catch (ClassNotFoundException | SQLException ex) {
            EstruturalLog.log("ERROR", "Classe não encontrada: "+ex.getMessage(), ex.getClass().getName());
            return DriverManager.getConnection(_URL);
        } 
            return null;
        
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            EstruturalLog.log("ERROR", ex.getMessage(), ex.getClass().getName());
        }
    }

    public static ResultSet executeResult(String query) {
        try {
            Statement statement = getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);

            EstruturalLog.log("INFO", "Executou a operação.", MainConnection.class.getName());

            return rs;

        } catch (SQLException ex) {
            EstruturalLog.log("ERROR", ex.getMessage(), ex.getClass().getName());
        }
        return null;
    }

    public static PreparedStatement excutePrepared(String query) {
        try {
            PreparedStatement pstm = getConnection().prepareStatement(query);
            EstruturalLog.log("INFO", "Executou a operação.", MainConnection.class.getName());
            return pstm;

        } catch (SQLException ex) {
            EstruturalLog.log("ERROR", ex.getMessage(), ex.getClass().getName());
        }

        return null;
    }
}
