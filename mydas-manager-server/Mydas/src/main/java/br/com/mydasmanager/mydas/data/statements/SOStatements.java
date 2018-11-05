package br.com.mydasmanager.mydas.data.statements;

public class SOStatements {

    public static final String INSERT_SO = "INSERT INTO so("
            + "  namesystem "
            + ", systemversion "
            + ", nameuser"
            + ", datecapture"
            + ", customerdevice)"
            + "VALUES (?, ?, ?, ?, ?)";
}
