package br.com.mydasmanager.mydas.model;

import br.com.mydasmanager.mydas.data.repositories.CustomerRepository;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.sql.Date;
import java.util.List;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public abstract class MainInformation {
    
    protected SystemInfo systemInfo = new SystemInfo();
    protected OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
    protected Date date = new Date(System.currentTimeMillis());
    
    protected Components components = JSensors.get.components();
    protected List<Cpu> cpus = components.cpus;
    protected List<Fan> fans = null;
    protected List<Temperature> temperatures = null;
            
    CustomerRepository customer = new CustomerRepository();
           
    protected int selectCustomerId(){
        return 100;
    }
    
    protected int selectDeviceId(){
        return 0;
    }
}
