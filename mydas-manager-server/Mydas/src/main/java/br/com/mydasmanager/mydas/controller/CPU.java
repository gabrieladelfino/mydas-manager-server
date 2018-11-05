package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.data.statements.CPURepository;
import br.com.mydasmanager.mydas.model.CPUModel;

public class CPU implements ComponentsMethods{

    @Override
    public void insert() {
        CPUModel m = new CPUModel();
        CPURepository.insert(m);
    }
}
