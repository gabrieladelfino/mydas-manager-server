package br.com.mydasmanager.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class EstruturalLog {

    public void log(String log, String type, String message, String fileName) {
        
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date());
        String content = String.format("[%s] %s %s %s.txt", type, date, message, fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(content, true))) {
            writer.write(log);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
