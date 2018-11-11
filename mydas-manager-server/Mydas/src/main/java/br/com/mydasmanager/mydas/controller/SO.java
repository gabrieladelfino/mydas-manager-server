package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.SOModel;
import br.com.mydasmanager.mydas.data.SORepository;

public class SO {

    public static void insert() {
        SOModel m = new SOModel();
        SORepository.insert(m);
    }
}
