package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.DeviceModel;
import br.com.mydasmanager.mydas.data.repositories.DeviceRepository;

public class Device {

    public static void insert() {
        DeviceModel m = new DeviceModel();
        DeviceRepository.insert(m);
    }

    public static void start() throws InterruptedException {
        Device.insert();
        Thread.sleep(1000);
    }

}
