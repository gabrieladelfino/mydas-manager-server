package br.com.mydasmanager.mydas.model;

import java.sql.Date;

public class GPUModel extends MainInformation {

    
    public String getGpuName() {
        System.out.println("Name: "+gpu.name );
        return gpu.name;
    }

    public Date getDateCapture() {
        return date;
    }

    public double getTemperature() {
        return Double.parseDouble(String.format("%d", gpu.sensors.temperatures.get(0)));
    }

    public Double getFan() {
        return Double.parseDouble(String.format("%d", gpu.sensors.fans.get(0)));
    }

    public int getDeviceId() {
        return selectDeviceId();
    }
}
