package br.com.mydasmanager.mydas.model;

import br.com.mydasmanager.mydas.controller.MainInformation;
import java.sql.Date;

public class GPUModel extends MainInformation {

    private String cpuName;

    public void setGpuName(String cpuName) {
        if (cpus != null) {
            cpus.forEach((cpu) -> {
                this.cpuName = cpu.name;
            });
        }
    }

    public String getGpuName() {
        return this.cpuName;
    }
    
    public double getTemperature() {
        return 0;
    }

    public String getFan() {
        return "";
    }

    public String getTotalMemory() {
        return "";
    }

    public Date getDateCapture() {
        return date;
    }

    public int getDeviceId() {
        return selectDeviceId();
    }
}
