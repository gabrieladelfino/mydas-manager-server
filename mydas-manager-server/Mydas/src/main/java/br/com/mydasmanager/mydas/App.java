package br.com.mydasmanager.mydas;

import br.com.mydasmanager.mydas.controller.Device;
import br.com.mydasmanager.mydas.controller.RAM;
import br.com.mydasmanager.mydas.controller.SO;

public class App {

    public static void main(String[] args) {
        
        Device device = new Device();
        device.CaptureInformation();
        
        RAM ram = new RAM();
        ram.CaptureInformation();
        
        SO so = new SO();
        so.CaptureInformation();
    }
}