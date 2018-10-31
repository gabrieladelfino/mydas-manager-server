package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.DeviceModel;
import br.com.mydasmanager.mydas.data.repositories.DeviceRepository;
import oshi.SystemInfo;

public class Device {

    public boolean CaptureInformation() {

        DeviceModel device = new DeviceModel();
        DeviceRepository deviceRepository = new DeviceRepository();

        try {

            deviceRepository.insertDeviceInformation(device);
            System.out.println("Executou.");

            return true;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }
}
