package br.com.mydasmanager.mydas.model;

public class CPUModel {

    private String model;
    
    private String ghz;

    private String processorName;

    private int core;

    private String currentUse;

    private long frequency;

    private double temperature;

    private String deviceId;
    
    private String dateCapture;

    public String getDateCapture() {
        return dateCapture;
    }

    public void setDateCapture(String dateCapture) {
        this.dateCapture = dateCapture;
    }
    

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public String getCurrentUse() {
        return currentUse;
    }

    public void setCurrentUse(String currentUse) {
        this.currentUse = currentUse;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getGhz() {
        return ghz;
    }

    public void setGhz(String ghz) {
        this.ghz = ghz;
    }

    
    
    

    

}
