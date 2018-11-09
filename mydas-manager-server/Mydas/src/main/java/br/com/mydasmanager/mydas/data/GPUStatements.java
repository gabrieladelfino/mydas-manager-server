package br.com.mydasmanager.mydas.data;

public class GPUStatements {

    public static final String INSERT_GPU = "INSERT INTO gpu("
            + "  temperature "
            + ", component "
            + ", fan"
            + ", customerdevice"
            + ", datecapture)"
            + "VALUES (?, ?, ?, ?, ?)";
}
