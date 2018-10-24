package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.RAM;
import br.com.mydasmanager.mydas.repositories.RAMRepository;
import oshi.SystemInfo;

public class RAMController {
    
    SystemInfo si = null;
    RAM ram = null;
   
    public boolean CaptureInformation(){
        
        si = new SystemInfo();
        ram = new RAM();
        
        try{
         
            ram.setFreeMemory(si.getHardware().getMemory().getAvailable());
            ram.setTotalMemory(si.getHardware().getMemory().getTotal());

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
