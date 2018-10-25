package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.SOModel;
import br.com.mydasmanager.mydas.data.repositories.CustomerRepository;
import br.com.mydasmanager.mydas.data.repositories.SORepository;
import java.sql.Date;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class SO {
    
    SystemInfo si = null;
    OperatingSystem operatingSystem = null;
    SOModel so = null;
    Date data;
    SORepository soRepository = null;
    CustomerRepository customer = null;
    int deviceid;
            
    public boolean CaptureInformation(){
        
        si = new SystemInfo();
        operatingSystem = si.getOperatingSystem();
        so = new SOModel();
        data = new Date(System.currentTimeMillis());
        soRepository = new SORepository();
        customer = new CustomerRepository();
        
        try{
            deviceid = soRepository.selectDeviceId(customer.getCustomerId());
            
            so.setNameSystem(operatingSystem.getFamily());
            so.setSystemVersion(operatingSystem.getVersion().getVersion());
            so.setNameUser(operatingSystem.getNetworkParams().getDomainName());
            so.setDeviceId(1005);
            
            soRepository.insertSOInformation(so);
         
            return true;
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return false;
    }
}
