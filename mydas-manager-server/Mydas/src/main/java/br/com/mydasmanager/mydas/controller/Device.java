package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.DeviceModel;
import br.com.mydasmanager.mydas.data.statements.DeviceRepository;

public class Device implements ComponentsMethods {

    @Override
    public void insert() {
        DeviceModel m = new DeviceModel();
        DeviceRepository.insert(m);
    }
}
