package br.com.mydasmanager.data;

public class CustomerDeviceStatements {

    public static final String SELECT_CUSTOMER_DEVICE_ID = "SELECT id FROM customer_device where customerid = ?"
            + "AND deviceid = (select max(deviceid) from customer_device where customerid = ?);";
}
