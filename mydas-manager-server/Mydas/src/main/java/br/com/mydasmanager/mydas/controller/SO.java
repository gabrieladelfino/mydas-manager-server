package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.SOModel;
import br.com.mydasmanager.mydas.data.repositories.SORepository;

public class SO {
    
    SOModel so = null;
    SORepository soRepository = null;
            
    public boolean CaptureInformation(){
        
        so = new SOModel();
        soRepository = new SORepository();
        
        try{
            soRepository.insertSOInformation(so);
         
            return true;
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return false;
    }
}
