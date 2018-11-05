package br.com.mydasmanager.mydas.data.statements;

public class GPUStatements {

    public static final String INSERT_GPU = "INSERT INTO gpu("
            + "  temperature "
            + ", component "
            + ", fan"
            + ", totalmemory"
            + ", customerdevice"
            + ", datecapture)"
            + "VALUES (?, ?, ?, ?, ?, ?)";
}
