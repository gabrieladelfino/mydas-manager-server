package br.com.mydasmanager.mydas.data;

/**
 *
 * @author Gabriela Garcia
 */
public class DeviceStatements {
    
    public static final String SELECT_INTERVAL_CAPTURE = "select interval from device where id = "
            + "(select max(deviceid) from customer_device)";
    
}
