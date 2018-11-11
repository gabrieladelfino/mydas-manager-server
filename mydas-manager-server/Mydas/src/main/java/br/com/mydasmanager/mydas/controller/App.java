package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.Initialize;
import java.sql.SQLException;

public class App {

    static boolean isRunning = true;

    public static void main(String[] args) throws SQLException {
        loadInformation(Initialize.selectInterval());
    }

    public static void loadInformation(int interval) throws SQLException {

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
