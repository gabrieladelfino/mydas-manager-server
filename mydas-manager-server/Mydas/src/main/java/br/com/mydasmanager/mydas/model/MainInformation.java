package br.com.mydasmanager.mydas.model;

import br.com.mydasmanager.mydas.data.CustomerRepository;
import java.sql.Date;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Gpu;
import java.util.List;

public abstract class MainInformation {

    protected SystemInfo systemInfo = new SystemInfo();
    protected OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
    protected Date date = new Date(System.currentTimeMillis());
    protected String name;
    protected double temperature;
    protected double fan;

    List<Gpu> gpus = JSensors.get.components().gpus;

    public void getGpu() {
        if (gpus.size() > 0) {
            gpus.forEach((gpu) -> {
                name = gpu.name;
                temperature = Double.parseDouble(String.format("%d", gpu.sensors.temperatures.get(0)));
                fan = Double.parseDouble(String.format("%d", gpu.sensors.fans.get(0)));
            });
        }
    }

    CustomerRepository customer = new CustomerRepository();

    protected int selectCustomerId() {
        return 100;
    }

    protected int selectDeviceId() {
        return 1004;
    }
}
