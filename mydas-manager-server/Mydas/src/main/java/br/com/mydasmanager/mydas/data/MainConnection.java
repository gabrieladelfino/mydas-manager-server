package br.com.mydasmanager.mydas.data;

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
            return DriverManager.getConnection(_URL);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ou classe não encontrada: " + e.getMessage());
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
            return rs;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public static PreparedStatement excutePrepared(String query) {
        try {
            PreparedStatement pstm = getConnection().prepareStatement(query);
            return pstm;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
