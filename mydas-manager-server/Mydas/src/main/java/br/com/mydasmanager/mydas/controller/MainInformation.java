package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.data.repositories.CustomerRepository;
import java.sql.Date;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public abstract class MainInformation {
    
    protected SystemInfo systemInfo = new SystemInfo();
    protected OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
    protected Date date = new Date(System.currentTimeMillis());
    
    CustomerRepository customer = new CustomerRepository();
           
    protected int selectCustomerId(){
        return 100;
    }
    
    protected int selectDeviceId(){
        return 0;
    }
}
