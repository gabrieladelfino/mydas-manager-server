package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.Initialize;

public class App {

    static boolean isRunning = true;

    public static void main(String[] args) {
        loadInformation(Initialize.selectInterval());
    }

    public static void loadInformation(int interval) {

        try {
            if (isRunning) {
                GPU.insert();
                CPU.insert();
                RAM.insert();
                SO.insert();
            }
            Thread.sleep(interval);
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
    }
}
