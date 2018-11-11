package br.com.mydasmanager.mydas.data;

/**
 *
 * @author Gabriela Garcia
 */
public class HDStatements {
    
    public static final String INSERT_HD = "INSERT INTO hd ("
            + "  bytesread"
            + ", byteswritten"
            + ", customerdeviceid)"
            + "VALUES(?, ?, ?)";
    
}
