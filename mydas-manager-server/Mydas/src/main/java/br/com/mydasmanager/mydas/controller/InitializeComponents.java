package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.Initialize;

/**
 *
 * @author Gabriela Garcia
 */
public class InitializeComponents {
    
    boolean isRunning = true;

    public InitializeComponents() throws InterruptedException {
        Device.insert();
        loadInformation(Initialize.selectInterval());
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
}
