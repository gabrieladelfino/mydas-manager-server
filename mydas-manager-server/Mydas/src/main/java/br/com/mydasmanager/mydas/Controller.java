package br.com.mydasmanager.mydas;

import br.com.mydasmanager.mydas.controller.RAMController;
import br.com.mydasmanager.mydas.controller.SOController;
import br.com.mydasmanager.mydas.controller.DeviceController;

public class Controller {

    public static void main(String[] args) {

        SOController so = new SOController();
        so.CaptureInformation();
        
        RAMController ram = new RAMController();
        ram.CaptureInformation();
        
        DeviceController device = new DeviceController();
        device.CaptureInformation();
    }
}