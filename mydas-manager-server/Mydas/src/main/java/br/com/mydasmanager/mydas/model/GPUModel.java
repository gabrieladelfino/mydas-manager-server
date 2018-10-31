package br.com.mydasmanager.mydas.model;

import br.com.mydasmanager.mydas.controller.MainInformation;
import java.sql.Date;
import java.util.List;

public class GPUModel extends MainInformation {
  
    public double getTemperature() {
        return 0;
    }

    public List<String> getComponent() {
        
        if (cpus != null) {
            cpus.forEach((cpu) -> {
                this.add(cpu.name);
            });
        }
       
        return (List<String>) this;
    }

    public String getFan() {
        return "";
    }

    public String getTotalMemory() {
        return "";
    }

    public int getCustomerId() {
        return selectCustomerId();
    }

    public Date getDateCapture() {
        return date;
    }
    
    public int getDeviceId(){
        return selectDeviceId();
    }

    private void add(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
