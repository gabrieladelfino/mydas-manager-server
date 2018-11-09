package br.com.mydasmanager.mydas.model;

import java.sql.Date;
import oshi.util.FormatUtil;

public class RAMModel extends MainInformation {

    public int getDeviceId() {
        return selectDeviceId();
    }

    public double getTotalmemory() {
        return this.toDouble(systemInfo.getHardware().getMemory().getTotal());
    }

    public double getFreememory() {
        return this.toDouble(systemInfo.getHardware().getMemory().getAvailable());
    }

    public double getCurrentUseMemory() {
        return this.toDouble((this.getTotalmemory()-this.getFreememory()));
    }
    
    public Date getDateCapture() {
        return date;
    }
    
   private double toDouble(long param){
       return Double.parseDouble(FormatUtil.formatBytes(param).split(" ")[0].replace(",","."));
   }
}
