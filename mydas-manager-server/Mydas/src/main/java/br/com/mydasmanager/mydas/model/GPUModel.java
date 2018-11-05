package br.com.mydasmanager.mydas.model;

import java.sql.Date;

public class GPUModel extends MainInformation {

    public String getGpuName() {
        return gpus != null
                ? gpus.get(1).name
                : null;
    }

    public Date getDateCapture() {
        return date;
    }

    public double getTemperature() {
        return gpus != null
                ? Double.parseDouble(String.format("%d", gpus.get(1).sensors.temperatures.get(1)))
                : null;
    }

    public Double getFan() {
        return gpus != null
                ? Double.parseDouble(String.format("%d", gpus.get(1).sensors.fans.get(1)))
                : null;
    }

    public int getDeviceId() {
        return selectDeviceId();
    }
}
