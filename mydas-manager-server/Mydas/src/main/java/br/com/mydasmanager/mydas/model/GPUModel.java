package br.com.mydasmanager.mydas.model;

import com.profesorfalken.jsensors.model.components.Gpu;
import java.sql.Date;

public class GPUModel extends MainInformation {

    public String getGpuName() {

        if (gpus.size() > 0) {
            for (final Gpu gpu : gpus) {
                return gpu.name;
            }
        }

        return null;
    }

    public Date getDateCapture() {
        return date;
    }

    public double getTemperature() {
        if (gpus.size() > 0) {
            return Double.parseDouble(String.format("%d", gpus.get(0).sensors.temperatures.get(0)));
        } else {
            return 0;
        }
    }

    public double getFan() {
        if (gpus.size() > 0) {
            return Double.parseDouble(String.format("%d", gpus.get(0).sensors.fans.get(0)));
        } else {
            return 0;
        }
    }

    public int getDeviceId() {
        return selectDeviceId();
    }
}
