package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.RAMModel;
import br.com.mydasmanager.mydas.data.repositories.RAMRepository;
import java.sql.Date;
import oshi.SystemInfo;

public class RAM {
    
    SystemInfo si = null;
    RAMModel ram = null;
    Date data;
    
    public boolean CaptureInformation(){
        
        si = new SystemInfo();
        ram = new RAMModel();
        data = new Date(System.currentTimeMillis());
        
        try{
         
            ram.setFreeMemory(si.getHardware().getMemory().getAvailable());
            ram.setTotalMemory(si.getHardware().getMemory().getTotal());
            ram.setDateCapture(data);
            
            RAMRepository ramRepository = new RAMRepository();
            ramRepository.insertRAMInformation(ram);
            
            System.out.println("Executou!");
            
            return true;
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return false;
    }
    
}
