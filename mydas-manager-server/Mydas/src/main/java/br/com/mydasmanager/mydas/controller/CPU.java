package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.data.CPURepository;
import br.com.mydasmanager.mydas.model.CPUModel;

public class CPU {

    public static void insert()  {
        CPUModel m = new CPUModel();
        CPURepository.insert(m);
    }
}
