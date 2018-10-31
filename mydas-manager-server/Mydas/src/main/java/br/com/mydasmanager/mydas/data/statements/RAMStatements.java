package br.com.mydasmanager.mydas.data.statements;

public abstract class RAMStatements {
    
    protected final String INSERT_RAM = "INSERT INTO ram("
                    + "  totalmemory"
                    + ", freememory"
                    + ", datecapture"
                    + ", deviceid)"
                    + "VALUES (?, ?, ?, ?)";
}
