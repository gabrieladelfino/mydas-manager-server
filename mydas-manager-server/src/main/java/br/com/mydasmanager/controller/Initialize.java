package br.com.mydasmanager.controller;

import br.com.mydasmanager.data.repository.DeviceRepository;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import java.util.List;
import oshi.util.FormatUtil;

public abstract class Initialize {

    protected SystemInfo systemInfo = new SystemInfo();
    protected OperatingSystem operatingSystem = systemInfo.getOperatingSystem();

    protected Components components = JSensors.get.components();
    protected List<Gpu> gpus = components.gpus;

    public static int selectDeviceId(int customerid) {
        return DeviceRepository.selectDeviceId(customerid);
    }

    public static int selectInterval(int id) {
        return DeviceRepository.selectInterval(id);
    }
    
    public static double toDouble(long param) {
        return Double.parseDouble(FormatUtil.formatBytes(param).split(" ")[0].replace(",", "."));
    }
}
