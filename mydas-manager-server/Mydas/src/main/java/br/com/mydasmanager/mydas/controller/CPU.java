package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.CPUModel;
import br.com.mydasmanager.mydas.repositories.CPURepository;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class CPU {

    SystemInfo si = null;
    OperatingSystem os = null;
    CPUModel cpu = null;

    public boolean CaptureInformation() {

        si = new SystemInfo();
        os = si.getOperatingSystem();
        cpu = new CPUModel();

        try {

            cpu.setProcessorName(si.getHardware().getProcessor().toString());
            cpu.setModel(si.getHardware().getProcessor().toString());
            cpu.setCurrentUse(si.getHardware().getClass().toString());
            cpu.setFrequency(si.getHardware().getProcessor().getVendorFreq());
            cpu.setCore(si.getHardware().getProcessor().getPhysicalProcessorCount());
            cpu.setTemperature(si.getHardware().getSensors().getCpuTemperature());
            cpu.setDeviceId(si.getHardware().getProcessor().getProcessorID());
            cpu.setGhz(si.getHardware().getProcessor().getName());

            CPURepository cpuRepository = new CPURepository();
            cpuRepository.insertCPUInformation(cpu);

            return true;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

}
