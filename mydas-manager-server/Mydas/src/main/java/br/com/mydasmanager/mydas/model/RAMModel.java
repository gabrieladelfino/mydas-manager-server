package br.com.mydasmanager.mydas.model;

public class RAMModel extends Initialize {

    public int getDeviceId() {
        return selectDeviceId();
    }

    public double getTotalmemory() {
        return toDouble(systemInfo.getHardware().getMemory().getTotal());
    }

    public double getFreememory() {
        return toDouble(systemInfo.getHardware().getMemory().getAvailable());
    }

    public double getCurrentMemoryUse() {
        return this.getTotalmemory() - this.getFreememory();
    }
}
