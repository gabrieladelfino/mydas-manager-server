package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.data.repositories.CustomerRepository;
import br.com.mydasmanager.mydas.model.DeviceModel;
import java.sql.Date;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public abstract class MainInformation {
    
    protected SystemInfo si = new SystemInfo();
    protected DeviceModel device = new DeviceModel();
    protected OperatingSystem operatingSystem = si.getOperatingSystem();
    protected Date data = new Date(System.currentTimeMillis());
    
    CustomerRepository customer = new CustomerRepository();
           
    protected int selectCustomerId(){
        return 0;
    }
    
    protected int selectDeviceId(){
        return 0;
    }
}
