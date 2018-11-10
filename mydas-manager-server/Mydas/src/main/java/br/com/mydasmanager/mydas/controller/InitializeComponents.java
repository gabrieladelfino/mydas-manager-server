package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.MainInformation;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author Gabriela Garcia
 */
public class InitializeComponents {

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);
    int seconds = calendar.get(Calendar.SECOND);

    boolean isRunning = true;

    String totalTimeRunning = "";
    String initialTimeRun = "";

    public InitializeComponents() throws InterruptedException {
        Device.insert();
        loadInformation(MainInformation.selectInterval());
    }

    public void loadInformation(int interval) {

        calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        seconds = calendar.get(Calendar.SECOND);

        totalTimeRunning = String.format("%d:%d:%d", hour, minute, seconds);

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
