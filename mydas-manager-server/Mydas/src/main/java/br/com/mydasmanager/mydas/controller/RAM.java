package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.RAMModel;
import br.com.mydasmanager.mydas.data.repositories.RAMRepository;

public class RAM {

    RAMModel ram = new RAMModel();
    RAMRepository ramRepository = new RAMRepository();

    public boolean CaptureInformation() {

        try {

            ramRepository.insertRAMInformation(ram);

            return true;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

}
