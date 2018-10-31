package br.com.mydasmanager.mydas.data.statements;

public class SOStatements {

    public static final String INSERT_SO = "INSERT INTO so("
            + "  namesystem "
            + ", systemversion "
            + ", nameuser"
            + ", datecapture"
            + ", deviceid)"
            + "VALUES (?, ?, ?, ?, ?)";

    public static final String SELECT_CUSTOMER_DEVICE_ID = "SELECT id FROM customer_device WHERE customer_id = ";

}
