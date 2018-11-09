package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.RAMModel;
import br.com.mydasmanager.mydas.data.RAMRepository;

public class RAM {

    public static void insert() {
        RAMModel m = new RAMModel();
        RAMRepository.insert(m);
    }
}
