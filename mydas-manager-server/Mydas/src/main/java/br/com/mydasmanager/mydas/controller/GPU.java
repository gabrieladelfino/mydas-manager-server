package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.data.statements.GPURepository;
import br.com.mydasmanager.mydas.model.GPUModel;

public class GPU implements ComponentsMethods {

    @Override
    public void insert() {
        GPUModel m = new GPUModel();
        GPURepository.insert(m);
    }
}
