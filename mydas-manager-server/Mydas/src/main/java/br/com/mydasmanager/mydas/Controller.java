package br.com.mydasmanager.mydas;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class Controller {

    public static void main(String[] args) {

        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hw = si.getHardware();
        System.out.println(hw.getMemory().getTotal());
        OperatingSystem sw = si.getOperatingSystem();
        System.out.println(sw.getVersion());
        int count = si.getOperatingSystem().getThreadCount();
        System.out.println(count);
    }
}
