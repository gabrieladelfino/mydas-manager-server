package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.data.repositories.CPURepository;
import br.com.mydasmanager.mydas.model.CPUModel;

/**
 *
 * @author Gabriela Garcia
 */
public class CPU {

    public static void insert() {
        CPUModel m = new CPUModel();
        CPURepository.insertCPUInformation(m);
    }

    public static void start() throws InterruptedException {
        CPU.insert();
        Thread.sleep(1000);
    }

}
