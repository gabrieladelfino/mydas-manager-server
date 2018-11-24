package br.com.mydasmanager.data;

/**
 *
 * @author Gabriela Garcia
 */
public class HDStatements {
    
    public static final String INSERT_HD = "INSERT INTO hd ("
            + "  bytesread"
            + ", byteswritten"
            + ", deviceid)"
            + "VALUES(?, ?, ?)";
    
    public static final String SELECT_BYTES_READ = "select bytesread from hd where deviceid = ?";
}
