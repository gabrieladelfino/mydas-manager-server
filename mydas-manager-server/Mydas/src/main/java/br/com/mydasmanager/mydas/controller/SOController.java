package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.SO;
import br.com.mydasmanager.mydas.repositories.SORepository;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class SOController {
    
    SystemInfo si = null;
    OperatingSystem os = null;
    SO operationalSystem = null;
    
            
    public boolean CaptureInformation(){
        
        si = new SystemInfo();
        os = si.getOperatingSystem();
        operationalSystem = new SO();
        
        try{
            operationalSystem.setNameSystem(os.getFamily());
            operationalSystem.setSystemVersion(os.getVersion().getVersion());
            operationalSystem.setNameUser(os.getNetworkParams().getDomainName());

            SORepository soRepository = new SORepository();
            soRepository.insertSOInformation(operationalSystem);
            
            return true;
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return false;
    }
}
