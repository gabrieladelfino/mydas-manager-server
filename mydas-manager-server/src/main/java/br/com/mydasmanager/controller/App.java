package br.com.mydasmanager.controller;

import br.com.mydasmanager.view.Login;

public class App {

    public static void main(String[] args) {
        new Login();
    }

//    public static void loadInformation() {
//        System.out.println(Initialize.isRunning());
//        System.out.println(Initialize.isRunning() == 1);
//        try {
//            while (Initialize.isRunning() == 1) {
//                GPURepository.insert(new GPUModel());
//                CPURepository.insert(new CPUModel());
//                RAMRepository.insert(new RAMModel());
//                SORepository.insert(new SOModel());
//                HDRepository.insert(new HDModel());
//            }
//            Thread.sleep(Initialize.selectInterval());
//        } catch (InterruptedException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
