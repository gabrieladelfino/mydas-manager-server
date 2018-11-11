package br.com.mydasmanager.data;

public class RAMStatements {

    public static final String INSERT_RAM = "INSERT INTO ram("
            + "  totalmemory"
            + ", freememory"
            + ", datecapture"
            + ", customerdevice"
            + ", memoryuse)"
            + "VALUES (?, ?, ?, ?, ?)";
}
