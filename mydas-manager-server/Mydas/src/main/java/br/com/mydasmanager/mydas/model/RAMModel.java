package br.com.mydasmanager.mydas.model;

import br.com.mydasmanager.mydas.controller.MainInformation;
import java.sql.Date;

public class RAMModel extends MainInformation {

    public int getDeviceId() {
        return 1004;
    }

    public long getTotalmemory() {
        return systemInfo.getHardware().getMemory().getTotal();
    }

    public long getFreememory() {
        return systemInfo.getHardware().getMemory().getAvailable();
    }

    public Date getDateCapture() {
        return date;
    }
}
