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
