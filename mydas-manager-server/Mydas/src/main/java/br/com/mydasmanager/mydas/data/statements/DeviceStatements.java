package br.com.mydasmanager.mydas.data.statements;

public class DeviceStatements {

    public static final String INSERT_CUSTOMER_DEVICE = "INSERT INTO customer_device("
            + "  currentnameuser"
            + ", customerid)"
            + "VALUES (?, ?)";
}
