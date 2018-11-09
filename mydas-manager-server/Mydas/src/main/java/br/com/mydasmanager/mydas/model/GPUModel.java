package br.com.mydasmanager.mydas.model;

import java.sql.Date;

public class GPUModel extends MainInformation {

    public String getGpuName() {
        return name;
    }

    public Date getDateCapture() {
        return date;
    }

    public double getTemperature() {
        return temperature;
    }

    public Double getFan() {
        return fan;
    }

    public int getDeviceId() {
        return selectDeviceId();
    }
}
