package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.SOModel;
import br.com.mydasmanager.mydas.data.statements.SORepository;

public class SO implements ComponentsMethods {

    @Override
    public void insert() {
        SOModel m = new SOModel();
        SORepository.insert(m);
    }

}
