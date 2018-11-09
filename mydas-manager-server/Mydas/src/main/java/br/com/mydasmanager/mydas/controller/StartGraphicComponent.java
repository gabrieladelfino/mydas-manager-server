package br.com.mydasmanager.mydas.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.TimeZone;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Gabriela Garcia
 */
public class StartGraphicComponent extends JFrame {

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);
    int seconds = calendar.get(Calendar.SECOND);

    boolean isRunning = true;

    String totalTimeRunning = "";
    String initialTimeRun = "";

    public StartGraphicComponent() throws InterruptedException {

        loadTextRunningTime(1000);
        loadInformation();
    }

    public void loadTextRunningTime(int interval) {
        new Timer(interval, (e) -> {
            if (isRunning) {
                calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);
                seconds = calendar.get(Calendar.SECOND);

                totalTimeRunning = String.format("%d:%d:%d", hour, minute, seconds);

                System.out.println("Type: " + e.getID());
            }
        }).start();
    }

    public void loadInformation() throws InterruptedException {
        System.out.println("br.com.mydasmanager.mydas.controller.StartGraphicComponent.loadInformation()");

        Device.insert();

        if (isRunning) {
            GPU.insert();
            CPU.insert();
            RAM.insert();
            SO.insert();
        }
    }
}
