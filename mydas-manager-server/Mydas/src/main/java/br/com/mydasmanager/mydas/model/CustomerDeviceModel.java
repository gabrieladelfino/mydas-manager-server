package br.com.mydasmanager.mydas.model;

public class CustomerDeviceModel extends Initialize{
 
    public int getDeviceId() {
        return selectDeviceId();
    }

    public int getCustomerId() {
        return selectCustomerId();
    }
}
