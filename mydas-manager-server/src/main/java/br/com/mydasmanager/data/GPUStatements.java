package br.com.mydasmanager.data;

public class GPUStatements {

    public static final String INSERT_GPU = "INSERT INTO gpu("
            + "  temperature "
            + ", name "
            + ", fan"
            + ", deviceid"
            + ", datecapture)"
            + "VALUES (?, ?, ?, ?, ?)";
}
