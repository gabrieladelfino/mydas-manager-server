package br.com.mydasmanager.data;

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
                    + ", temperature"
                    + ", customerdevice"
                    + ", datecapture)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
}
