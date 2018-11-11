package br.com.mydasmanager.mydas.data;

public class CustomerDeviceStatements {

    public static final String SELECT_MAX_CUSTOMER_DEVICE_ID = "SELECT MAX(id) FROM customer_device";
    public static final String SELECT_INTERVAL = "SELECT interval WHERE id = "+SELECT_MAX_CUSTOMER_DEVICE_ID;
}
