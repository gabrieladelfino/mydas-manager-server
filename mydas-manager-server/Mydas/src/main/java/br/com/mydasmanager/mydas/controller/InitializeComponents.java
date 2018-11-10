package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.CaptureDate;
import br.com.mydasmanager.mydas.model.MainInformation;


/**
 *
 * @author Gabriela Garcia
 */
public class InitializeComponents {

   
    boolean isRunning = true;

    String totalTimeRunning = "";
    String initialTimeRun = "";

    public InitializeComponents() throws InterruptedException {
        Device.insert();
        loadInformation(MainInformation.selectInterval());
    }

    public void loadInformation(int interval) {
        
        try {
            if (isRunning) {
                GPU.insert();
                CPU.insert();
                RAM.insert();
                SO.insert();
            }
            Thread.sleep(interval);
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
    }
    
    public String getDateCapture() {
        return CaptureDate.selectDate();
    }
    
    public String getHourCapture() {
        return CaptureDate.selectHourOfDay();
    }
}
