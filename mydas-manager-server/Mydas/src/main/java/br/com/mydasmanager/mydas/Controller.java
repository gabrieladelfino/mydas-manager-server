package br.com.mydasmanager.mydas;

import br.com.mydasmanager.mydas.model.SO;
import br.com.mydasmanager.mydas.repositories.DeviceRepository;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class Controller {

    public static void main(String[] args) {

        SystemInfo si = new SystemInfo();
        SO operationalSystem = new SO();
        OperatingSystem os = si.getOperatingSystem();
        
        operationalSystem.setNameSystem(os.getFamily());
        operationalSystem.setSystemVersion(os.getVersion().getVersion());
        operationalSystem.setNameUser(os.getNetworkParams().getDomainName());
        
        DeviceRepository dv = new DeviceRepository();
        dv.insertSOInformation(operationalSystem);
    }
}
