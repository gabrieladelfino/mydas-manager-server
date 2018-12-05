package br.com.mydasmanager.data.repository;

import br.com.mydasmanager.controller.EstruturalLog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainConnection.class);

    public static Connection getConnection() {

        final String _URL = "jdbc:sqlserver://mydasmanager.database.windows.net:1433;database=mydas-manager;"
                + "user=mydas.manager@mydasmanager;password={Digital@2018};"
                + "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;"
                + "loginTimeout=30;";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(_URL);
        } catch (ClassNotFoundException | SQLException ex) {
             EstruturalLog.log("ERROR", ex.getMessage(), "log_mainConnection_");
            return null;
        }
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static ResultSet executeResult(String query) {
        try {
            Statement statement = getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            EstruturalLog.log("INFO", "Operação executada", "log_mainConnection_");
            return rs;

        } catch (SQLException ex) {
            EstruturalLog.log("ERROR", ex.getMessage(), "log_mainConnection_");
        }
        
        EstruturalLog.log("ERROR", "Operação executada", "log_mainConnection_");
        return null;
    }

    public static PreparedStatement excutePrepared(String query) {
        try {
            PreparedStatement pstm = getConnection().prepareStatement(query);
            EstruturalLog.log("INFO", "Operação executada", "log_mainConnection_");
            return pstm;

        } catch (SQLException ex) {
            EstruturalLog.log("ERROR", ex.getMessage(), "log_mainConnection_");
        }

        EstruturalLog.log("ERROR", "Ocorreu um erro inesperado", "log_mainConnection_");
        return null;
    }
}
