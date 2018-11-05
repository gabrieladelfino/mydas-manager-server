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

    JLabel labelRunningTime;
    JLabel runningTime;
    JLabel labelComponents;
    JLabel components;
    JButton stop;

    int axisX = 60;
    int axisY = 20;
    int spaceX = 20;
    int spaceY = 10;

    final String stopText = "Parar";
    final String playText = "Retomar";

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);
    int seconds = calendar.get(Calendar.SECOND);

    boolean isRunning = true;

    String totalTimeRunning = "";

    public StartGraphicComponent() throws InterruptedException {

        setSize(800, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(GraphicsComponents.WHITE);

        labelRunningTime = new JLabel("Tempo em execução: ");
        labelRunningTime.setSize(130, 20);
        labelRunningTime.setLocation(axisX, axisY);
        add(labelRunningTime);

        runningTime = new JLabel();
        runningTime.setSize(300, 200);
        runningTime.setLocation(axisX, (labelRunningTime.getHeight() + axisY + spaceY));
        runningTime.setBackground(GraphicsComponents.RED);
        runningTime.setOpaque(true);
        runningTime.setHorizontalTextPosition(SwingConstants.CENTER);
        add(runningTime);

        labelComponents = new JLabel("Componentes monitorados: ");

        labelComponents.setSize(170, 20);
        labelComponents.setLocation((runningTime.getX() + runningTime.getWidth() + spaceX), axisY);
        add(labelComponents);

        components = new JLabel();
        components.setSize(300, 200);
        components.setLocation(labelComponents.getX(), runningTime.getY());
        components.setBackground(GraphicsComponents.GREEN);
        components.setOpaque(true);
        add(components);

        stop = new JButton(stopText);
        stop.setSize(runningTime.getWidth() + components.getWidth() + spaceX, 35);
        stop.setLocation(axisX, components.getWidth() + spaceY);
        stop.setBackground(GraphicsComponents.BLACK);
        stop.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (stop.getText().equals(stopText)) {
                    stop.setText(playText);
                } else {
                    stop.setText(stopText);
                }

                isRunning = !isRunning;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(stop);

        setVisible(true);
        this.show();

        loadTextRunningTime();
        loadInformation();
    }

    public void loadTextRunningTime() {
        new Timer(100, (ActionEvent e) -> {
            if (isRunning) {
                calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);
                seconds = calendar.get(Calendar.SECOND);

                totalTimeRunning = String.format("%d:%d:%d", hour, minute, seconds);
                runningTime.setText(totalTimeRunning);
            }
        }).start();
    }

    public void loadInformation() throws InterruptedException {
        Device.insert();
        if (isRunning) {
            new Timer(1000, (ActionEvent e) -> {
                RAM.insert();
                SO.insert();
                CPU.insert();
            }).start();
        }
    }
}
