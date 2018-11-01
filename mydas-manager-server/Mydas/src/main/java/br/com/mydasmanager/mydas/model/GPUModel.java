package br.com.mydasmanager.mydas.model;

import br.com.mydasmanager.mydas.controller.MainInformation;
import java.sql.Date;

public class GPUModel extends MainInformation {

    private String cpuName;
    private Double temperature;
    private Double fan;

    public String getGpuName() {
        return this.cpuName;
    }

    public Date getDateCapture() {
        return date;
    }

    public void setGpuName() {
        if (cpus != null) {
            cpus.forEach((cpu) -> {
                this.cpuName = cpu.name;
            });
        }
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature() {
        if (cpus != null) {
            temperatures.forEach((temperature) -> {
                this.temperature = temperature.value;
            });
        }
    }

    public void setFan() {
        if (cpus != null) {
            temperatures.forEach((fan) -> {
                this.fan = fan.value;
            });
        }
    }

    public Double getFan() {
        return this.fan;
    }

    public int getDeviceId() {
        return selectDeviceId();
    }
}
