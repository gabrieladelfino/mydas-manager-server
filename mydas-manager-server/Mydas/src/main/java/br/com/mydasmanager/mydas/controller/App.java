package br.com.mydasmanager.mydas.controller;

public class App {

    public static void main(String[] args) {

        try {
            CPU.start();
            RAM.start();
            GPU.start();
            SO.start();
            Device.start();
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
    }
}
