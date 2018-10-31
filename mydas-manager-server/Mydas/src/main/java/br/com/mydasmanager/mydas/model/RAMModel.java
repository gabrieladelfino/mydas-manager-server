package br.com.mydasmanager.mydas.model;

import java.sql.Date;
import oshi.SystemInfo;

public class RAMModel {
    
    SystemInfo si = new SystemInfo();
   
    private int deviceId;
    private long totalmemory;
    private long freememory;
    private Date dateCapture;

    public int getDeviceId() {
        return 1004;
    }
    
    public long getTotalmemory() {
        return si.getHardware().getMemory().getTotal();
    }

    public long getFreememory() {
        return si.getHardware().getMemory().getAvailable();
    }

    public Date getDateCapture() {
        return new Date(System.currentTimeMillis());
    }
}
