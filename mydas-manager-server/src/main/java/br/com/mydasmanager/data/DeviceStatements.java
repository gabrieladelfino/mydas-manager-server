package br.com.mydasmanager.data;

/**
 *
 * @author Gabriela Garcia
 */
public class DeviceStatements {
    public static final String SELECT_INTERVAL_CAPTURE = "select interval from device where id = ?";
    public static final String SELECT_IS_RUNNING = "select status from device where id = ?";
}
