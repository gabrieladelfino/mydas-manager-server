package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.DeviceInformation;
import br.com.mydasmanager.mydas.repositories.DeviceRepository;
import oshi.SystemInfo;

public class DeviceController {
    
    SystemInfo si = null;
    DeviceInformation device = null;
   
    public boolean CaptureInformation(){
        
        si = new SystemInfo();
        device = new DeviceInformation();
        
        try{
         
            device.setNameUser(si.getOperatingSystem().getProcess(0).getUser());

            DeviceRepository deviceRepository = new DeviceRepository();
            deviceRepository.insertDeviceInformation(device);
            
            System.out.println("Executou!");
            
            return true;
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return false;
    }
}
