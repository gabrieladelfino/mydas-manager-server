package br.com.mydasmanager.model;

import br.com.mydasmanager.controller.Initialize;

public class RAMModel extends Initialize {
    
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
