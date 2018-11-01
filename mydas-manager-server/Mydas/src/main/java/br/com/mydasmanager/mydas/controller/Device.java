package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.DeviceModel;
import br.com.mydasmanager.mydas.data.repositories.DeviceRepository;

public class Device {

    public boolean CaptureInformation() {

        try {

            DeviceModel device = new DeviceModel();
            DeviceRepository deviceRepository = new DeviceRepository();

            deviceRepository.insertDeviceInformation(device);
            
            return true;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }
}
