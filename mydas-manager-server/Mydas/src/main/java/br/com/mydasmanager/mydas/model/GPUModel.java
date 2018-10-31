package br.com.mydasmanager.mydas.model;

import br.com.mydasmanager.mydas.controller.MainInformation;
import java.sql.Date;

public class GPUModel extends MainInformation{
   
    public double getTemperature() {
        return 0;
    }

    public String getComponent() {
        return "";
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
}
