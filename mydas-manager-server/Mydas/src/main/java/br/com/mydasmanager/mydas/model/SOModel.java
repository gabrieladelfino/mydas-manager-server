package br.com.mydasmanager.mydas.model;

import java.sql.Date;

public class SOModel extends MainInformation {

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
