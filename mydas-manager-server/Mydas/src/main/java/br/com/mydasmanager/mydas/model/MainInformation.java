package br.com.mydasmanager.mydas.model;

import br.com.mydasmanager.mydas.data.repositories.CustomerRepository;
import java.sql.Date;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public abstract class MainInformation {
    
    SystemInfo si = new SystemInfo();
    DeviceModel device = new DeviceModel();
    OperatingSystem operatingSystem = si.getOperatingSystem();
    Date data = new Date(System.currentTimeMillis());
    CustomerRepository customer = new CustomerRepository();
           
    int selectCustomerId(){
        return 0;
    }
    
    int selectDeviceId(){
        return 0;
    }
}
