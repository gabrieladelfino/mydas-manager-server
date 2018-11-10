package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.CustomerDeviceModel;
import br.com.mydasmanager.mydas.data.CustomerDeviceRepository;

public class Device {

    public static void insert() {
        CustomerDeviceModel m = new CustomerDeviceModel();
        CustomerDeviceRepository.insert(m);
    }
}
