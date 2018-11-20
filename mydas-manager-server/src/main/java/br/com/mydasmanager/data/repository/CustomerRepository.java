package br.com.mydasmanager.data.repository;

import br.com.mydasmanager.data.CustomerStatements;
import br.com.mydasmanager.data.MainConnection;
import br.com.mydasmanager.model.Customer;
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
public class CustomerRepository {

    public static int verifyLogin(Customer customer) {
        try {
            PreparedStatement pstm = MainConnection.excutePrepared(CustomerStatements.SELECT_LOGIN);
            pstm.setString(1, customer.getUserName());
            pstm.setString(2, customer.getPassword());

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public static int verifyCode(Customer customer) {
        try {
            PreparedStatement pstm = MainConnection.excutePrepared(CustomerStatements.SELECT_CODE_ACESS);
            pstm.setString(1, customer.getCodeAcess());

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public static List<String> selectDevice(int id) {

        List<String> data = new ArrayList();

        try {
            PreparedStatement pstm = MainConnection.excutePrepared(CustomerStatements.SELECT_DEVICE);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                data.add(rs.getString("machinename"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDeviceRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }
}
