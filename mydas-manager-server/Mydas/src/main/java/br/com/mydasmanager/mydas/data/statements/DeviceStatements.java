package br.com.mydasmanager.mydas.data.statements;

public class DeviceStatements {
   
    protected final String INSERT_CUSTOMER_DEVICE = "INSERT INTO customer_device("
                    + "  currentnameuser"
                    + ", customerid)"
                    + "VALUES (?, ?)";
}
