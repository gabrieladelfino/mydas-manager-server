package br.com.mydasmanager.mydas.model;

import oshi.util.FormatUtil;

public class RAMModel extends MainInformation {

    public int getDeviceId() {
        return selectDeviceId();
    }

    public double getTotalmemory() {
        return this.toDouble(systemInfo.getHardware().getMemory().getTotal());
    }

    public double getFreememory() {
        return this.toDouble(systemInfo.getHardware().getMemory().getAvailable());
    }

    public double getCurrentMemoryUse() {
        return this.getTotalmemory() - this.getFreememory();
    }

    private double toDouble(long param) {
        return Double.parseDouble(FormatUtil.formatBytes(param).split(" ")[0].replace(",", "."));
    }
}
