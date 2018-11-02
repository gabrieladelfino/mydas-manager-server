package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.SOModel;
import br.com.mydasmanager.mydas.data.repositories.SORepository;

public class SO {

    public static void insert() {
        SOModel m = new SOModel();
        SORepository.insert(m);
    }

    public static void start() throws InterruptedException {
        insert();
        Thread.sleep(1000);
    }
}
