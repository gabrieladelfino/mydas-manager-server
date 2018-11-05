package br.com.mydasmanager.mydas.data.statements;

/**
 *
 * @author Gabriela Garcia
 */
public class CPUStatements {
    
    public static final String INSERT_CPU = "INSERT INTO cpu("
                    + "model, "
                    + "ghz,"
                    + "processorname, "
                    + "core, "
                    + "currentuse, "
                    + "frequency, "
                    + "temperature, "
                    + "customerdevice, "
                    + "datecapture)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
