package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.RAMModel;
import br.com.mydasmanager.mydas.data.statements.RAMRepository;

public class RAM implements ComponentsMethods{

    @Override
    public void insert() {
        RAMModel m = new RAMModel();
        RAMRepository.insert(m);
    }
}
