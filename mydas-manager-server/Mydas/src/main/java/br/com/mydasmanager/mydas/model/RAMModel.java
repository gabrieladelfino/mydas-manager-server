package br.com.mydasmanager.mydas.model;

import java.sql.Date;

public class RAMModel {
    
    private int deviceid;
    private long totalmemory;
    private long freememory;
    private Date dateCapture;

    public int getDeviceid() {
        return deviceid;
    }
    
    public long getTotalmemory() {
        return totalmemory;
    }

    public void setTotalMemory(long totalmemory) {
        this.totalmemory = totalmemory;
    }

    public long getFreememory() {
        return freememory;
    }

    public void setFreeMemory(long freememory) {
         this.freememory = freememory;
    }

    public Date getDateCapture() {
        return dateCapture;
    }

    public void setDateCapture(Date dateCapture) {
        this.dateCapture = dateCapture;
    }
}
