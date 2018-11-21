package br.com.mydasmanager.data;

public class SOStatements {

    public static final String INSERT_SO = "INSERT INTO so("
            + "  namesystem "
            + ", systemversion "
            + ", nameuser"
            + ", datecapture"
            + ", deviceid)"
            + "VALUES (?, ?, ?, ?, ?)";
}
