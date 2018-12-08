package br.com.mydasmanager.data;

/**
 *
 * @author Gabriela Garcia
 */
public class DeviceStatements {

    public static final String SELECT_INTERVAL_CAPTURE = "select interval from device where id = ?";
    public static final String SELECT_ID = "select max(id) as id from device where customerid = ?";
    public static final String SELECT_DEVICES = "SELECT * FROM device WHERE customerid = ?";
}
