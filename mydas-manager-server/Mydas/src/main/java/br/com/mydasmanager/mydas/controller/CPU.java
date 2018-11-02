/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        insert();
        Thread.sleep(1000);
    }

}
