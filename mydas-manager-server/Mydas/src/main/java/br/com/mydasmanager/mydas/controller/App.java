package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.data.CPURepository;
import br.com.mydasmanager.mydas.data.GPURepository;
import br.com.mydasmanager.mydas.data.HDRepository;
import br.com.mydasmanager.mydas.data.RAMRepository;
import br.com.mydasmanager.mydas.data.SORepository;
import br.com.mydasmanager.mydas.model.CPUModel;
import br.com.mydasmanager.mydas.model.GPUModel;
import br.com.mydasmanager.mydas.model.HDModel;
import br.com.mydasmanager.mydas.model.Initialize;
import br.com.mydasmanager.mydas.model.RAMModel;
import br.com.mydasmanager.mydas.model.SOModel;

public class App {

    static boolean isRunning = true;

    public static void main(String[] args) {
        loadInformation(Initialize.selectInterval());
    }

    public static void loadInformation(int interval) {

        try {
            if (isRunning) {
                GPURepository.insert(new GPUModel());
                CPURepository.insert(new CPUModel());
                RAMRepository.insert(new RAMModel());
                SORepository.insert(new SOModel());
                HDRepository.insert(new HDModel());
            }
            Thread.sleep(interval);
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
    }
}
