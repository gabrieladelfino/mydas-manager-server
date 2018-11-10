package br.com.mydasmanager.mydas.model;

import br.com.mydasmanager.mydas.data.CustomerRepository;
import br.com.mydasmanager.mydas.data.CustomerDeviceRepository;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import java.util.List;

public abstract class Initialize {

    protected SystemInfo systemInfo = new SystemInfo();
    protected OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
  
    Components components = JSensors.get.components();
    List<Gpu> gpus = components.gpus;

    protected int selectCustomerId() {
        return CustomerRepository.selectMaxCustomerId();
    }

    protected int selectDeviceId() {
        return CustomerDeviceRepository.selectMaxDeviceId();
    }

    public static int selectInterval() {
        return 1000;
    }
}
