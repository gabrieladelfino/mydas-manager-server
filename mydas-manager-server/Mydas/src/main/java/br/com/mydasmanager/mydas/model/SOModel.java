package br.com.mydasmanager.mydas.model;

public class SOModel extends Initialize {

    public String getNameSystem() {
        return operatingSystem.getFamily();
    }

    public String getSystemVersion() {
        return operatingSystem.getVersion().getVersion();
    }

    public String getNameUser() {
        return operatingSystem.getNetworkParams().getDomainName();
    }

    public int getDeviceId() {
        return selectDeviceId();
    }
}
