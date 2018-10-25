package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.DeviceModel;
import br.com.mydasmanager.mydas.data.repositories.DeviceRepository;
import oshi.SystemInfo;

public class Device {
    
    SystemInfo si = null;
    DeviceModel device = null;
   
    public boolean CaptureInformation(){
        
        si = new SystemInfo();
        device = new DeviceModel();
        
        try{
         
            device.setNameUser(si.getOperatingSystem().getProcess(0).getUser());
            device.setCustomerId(100);
            
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
