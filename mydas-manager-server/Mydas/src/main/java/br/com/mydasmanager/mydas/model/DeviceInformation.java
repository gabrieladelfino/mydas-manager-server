package br.com.mydasmanager.mydas.model;

public class DeviceInformation {
    
    private int id;
    private int customerId;
    private String nameUser;

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
}
