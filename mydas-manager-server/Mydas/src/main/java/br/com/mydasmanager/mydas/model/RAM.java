package br.com.mydasmanager.mydas.model;

public class RAM {
    
    private int deviceid;
    private long totalmemory;
    private long freememory;

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
}
