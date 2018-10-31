package br.com.mydasmanager.mydas.model;

import br.com.mydasmanager.mydas.controller.MainInformation;

public class DeviceModel extends MainInformation{
 
    public int getDeviceId() {
        return selectDeviceId();
    }

    public int getCustomerId() {
        return selectCustomerId();
    }

    public String getNameUser() {
        return si.getOperatingSystem().getProcess(0).getUser();
    }
}
