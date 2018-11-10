package br.com.mydasmanager.mydas.data;

/**
 *
 * @author Gabriela Garcia
 */
public class CPUStatements {
    
    public static final String INSERT_CPU = "INSERT INTO cpu("
                    + "  model"
                    + ", ghz"
                    + ", core"
                    + ", currentuse"
                    + ", frequency"
                    + ", temperature"
                    + ", customerdevice"
                    + ", datecapture)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
