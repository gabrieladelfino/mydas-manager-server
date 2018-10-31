package br.com.mydasmanager.mydas.data.statements;

public abstract class DeviceStatements {
   
    protected final String INSERT_CUSTOMER_DEVICE = "INSERT INTO customer_device("
                    + "  currentnameuser"
                    + ", customerid)"
                    + "VALUES (?, ?)";
}
