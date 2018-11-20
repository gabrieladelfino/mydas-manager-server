package br.com.mydasmanager.data;

public class RAMStatements {

    public static final String INSERT_RAM = "INSERT INTO ram("
            + "  totalmemory"
            + ", freememory"
            + ", datecapture"
            + ", deviceid"
            + ", memoryuse)"
            + "VALUES (?, ?, ?, ?, ?)";

    public static final String SELECT_FREE_MEMORY = "SELECT * FROM ram WHERE deviceid =  ?";
}
