package br.com.mydasmanager.model;

import br.com.mydasmanager.controller.Initialize;

public class SOModel extends Initialize {

    public String getNameSystem() {
        return operatingSystem.getFamily();
    }

    public String getSystemVersion() {
        return operatingSystem.getVersion().getVersion();
    }

    public String getNameUser() {
        return systemInfo.getOperatingSystem().getProcess(0).getUser();
    }
}
