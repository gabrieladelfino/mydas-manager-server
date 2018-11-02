package br.com.mydasmanager.mydas.model;

import br.com.mydasmanager.mydas.controller.MainInformation;
import java.sql.Date;

public class CPUModel extends MainInformation {

    public Date getDateCapture() {
        return date;
    }

    public String getModel() {
        return systemInfo.getHardware().getProcessor().toString();
    }

    public String getProcessorName() {
        return systemInfo.getHardware().getProcessor().toString();
    }

    public int getCore() {
        return systemInfo.getHardware().getProcessor().getPhysicalProcessorCount();
    }

    public String getCurrentUse() {
        return systemInfo.getHardware().getClass().toString();
    }

    public long getFrequency() {
        return systemInfo.getHardware().getProcessor().getVendorFreq();
    }

    public double getTemperature() {
        return systemInfo.getHardware().getSensors().getCpuTemperature();
    }

    public int getDeviceId() {
        return selectDeviceId();
    }

    public String getGhz() {
        return systemInfo.getHardware().getProcessor().getName();
    }
}
