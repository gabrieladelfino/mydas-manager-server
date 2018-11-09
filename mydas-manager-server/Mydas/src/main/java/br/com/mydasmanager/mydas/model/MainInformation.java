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

    List<Gpu> gpus = JSensors.get.components().gpus;
    
    CustomerRepository customer = new CustomerRepository();

    protected int selectCustomerId() {
        return 100;
    }

    protected int selectDeviceId() {
        return 1004;
    }
}
