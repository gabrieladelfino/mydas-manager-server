package br.com.mydasmanager.model;

import br.com.mydasmanager.controller.Initialize;
import static br.com.mydasmanager.controller.Initialize.toDouble;

/**
 *
 * @author Gabriela Garcia
 */
public class HDModel extends Initialize {

    public double getBytesRead() {
        return toDouble(systemInfo.getOperatingSystem().getProcess(0).getBytesRead());
    }

    public double getBytesWritten() {
        return toDouble(systemInfo.getOperatingSystem().getProcess(0).getBytesWritten());
    }

    public int getDeviceId() {
        return selectDeviceId();
    }
}
