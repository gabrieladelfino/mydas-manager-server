package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.RAMModel;
import br.com.mydasmanager.mydas.data.repositories.RAMRepository;

public class RAM {
    
    RAMModel ram = null;
  
    public boolean CaptureInformation(){
        
        ram = new RAMModel();
        
        try{
        
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
