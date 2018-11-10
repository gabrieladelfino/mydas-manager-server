package br.com.mydasmanager.mydas.model;

import java.text.DecimalFormat;

public class CPUModel extends Initialize {

    DecimalFormat df = new DecimalFormat("#,##");
    StringBuilder model = new StringBuilder(systemInfo.getHardware().getProcessor().getName());
    StringBuilder ghz = new StringBuilder(systemInfo.getHardware().getProcessor().getName());

    public String getModel() {
        return model.replace(model.indexOf("CPU"), model.length(), "").toString();
    }

    public int getCore() {
        return systemInfo.getHardware().getProcessor().getPhysicalProcessorCount();
    }

    public String getCurrentUse() {
        return df.format(systemInfo.getHardware().getProcessor().getSystemCpuLoadBetweenTicks());
    }

    public String getTemperature() {
        return df.format(systemInfo.getHardware().getSensors().getCpuTemperature());
    }

    public String getGhz() {
        return ghz.replace(0, ghz.indexOf("@") + 2, "").toString();
    }

    public int getDeviceId() {
        return selectDeviceId();
    }
}
