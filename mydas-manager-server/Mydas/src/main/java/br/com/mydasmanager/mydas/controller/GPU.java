package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.data.repositories.GPURepository;
import br.com.mydasmanager.mydas.model.GPUModel;

public class GPU {

    public static void insert() {
        GPUModel m = new GPUModel();
        GPURepository.insert(m);
    }

    public static void start() throws InterruptedException {
        insert();
        Thread.sleep(1000);
    }
}
