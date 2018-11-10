package br.com.mydasmanager.mydas.model;

import oshi.SystemInfo;

public class CPUModel extends Initialize {
    
    public String getModel() {
        return systemInfo.getHardware().getProcessor().toString();
    }

    public String getProcessorName() {
        return systemInfo.getHardware().getProcessor().toString();
    }

    public int getCore() {
        return systemInfo.getHardware().getProcessor().getPhysicalProcessorCount();
    }

    public double getCurrentUse() {
        return systemInfo.getHardware().getProcessor().getSystemCpuLoadBetweenTicks();
    }

    public long getFrequency() {
        return systemInfo.getHardware().getProcessor().getVendorFreq();
    }

    public double getTemperature() {
        return systemInfo.getHardware().getSensors().getCpuTemperature();
    }

    public String getGhz() {
        return systemInfo.getHardware().getProcessor().getName();
    }

    public int getDeviceId() {
        return selectDeviceId();
    }
}
