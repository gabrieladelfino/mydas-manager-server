package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.SOModel;
import br.com.mydasmanager.mydas.data.repositories.SORepository;

public class SO {

    SOModel so = new SOModel();
    SORepository soRepository = new SORepository();

    public boolean CaptureInformation() {

        try {

            soRepository.insertSO(so);

            return true;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }
}
