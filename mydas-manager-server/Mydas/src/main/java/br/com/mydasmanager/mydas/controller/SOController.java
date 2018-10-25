package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.SO;
import br.com.mydasmanager.mydas.repositories.CustomerRepository;
import br.com.mydasmanager.mydas.repositories.SORepository;
import java.sql.Date;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class SOController {
    
    SystemInfo si = null;
    OperatingSystem os = null;
    SO operationalSystem = null;
    Date data;
    SORepository soRepository = null;
    CustomerRepository customer = null;
    int deviceid;
            
    public boolean CaptureInformation(){
        
        si = new SystemInfo();
        os = si.getOperatingSystem();
        operationalSystem = new SO();
        data = new Date(System.currentTimeMillis());
        soRepository = new SORepository();
        customer = new CustomerRepository();
        
        try{
            deviceid = soRepository.selectDeviceId(customer.getCustomerId());
            
            operationalSystem.setNameSystem(os.getFamily());
            operationalSystem.setSystemVersion(os.getVersion().getVersion());
            operationalSystem.setNameUser(os.getNetworkParams().getDomainName());
            operationalSystem.setDeviceid(deviceid);
            
            soRepository.insertSOInformation(operationalSystem);
         
            return true;
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return false;
    }
}
