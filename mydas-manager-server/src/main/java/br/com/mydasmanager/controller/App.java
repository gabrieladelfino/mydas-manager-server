package br.com.mydasmanager.controller;

import br.com.mydasmanager.data.repository.CPURepository;
import br.com.mydasmanager.data.repository.GPURepository;
import br.com.mydasmanager.data.repository.HDRepository;
import br.com.mydasmanager.data.repository.RAMRepository;
import br.com.mydasmanager.data.repository.SORepository;
import br.com.mydasmanager.model.CPUModel;
import br.com.mydasmanager.model.GPUModel;
import br.com.mydasmanager.model.HDModel;
import br.com.mydasmanager.model.RAMModel;
import br.com.mydasmanager.model.SOModel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) {
        try {
            loadInformation();
            Thread.sleep(Initialize.selectInterval());
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadInformation() {
        try {
            while (Initialize.isRunning() == 1) {
                GPURepository.insert(new GPUModel());
                CPURepository.insert(new CPUModel());
                RAMRepository.insert(new RAMModel());
                SORepository.insert(new SOModel());
                HDRepository.insert(new HDModel());
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
