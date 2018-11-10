package br.com.mydasmanager.mydas.data;

public class CustomerDeviceStatements {

    public static final String INSERT_CUSTOMER_DEVICE = "INSERT INTO customer_device("
            + "  deviceid"
            + ", customerid)"
            + "VALUES (?, ?)";

    public static final String SELECT_MAX_CUSTOMER_DEVICE_ID = "SELECT MAX(id) FROM customer_device";
}
