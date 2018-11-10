package br.com.mydasmanager.mydas.model;

public class DeviceModel extends Initialize{
 
    public int getDeviceId() {
        return selectDeviceId();
    }

    public int getCustomerId() {
        return selectCustomerId();
    }

    public String getNameUser() {
        return systemInfo.getOperatingSystem().getProcess(0).getUser();
    }
}
