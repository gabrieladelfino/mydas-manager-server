package br.com.mydasmanager.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class EstruturalLog {

    public static void log(String type, String message, String fileName) {

        String date = new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date());
        String hour = new SimpleDateFormat("hh:mm:ss").format(new java.util.Date());

        String content = String.format("[%s] [%s %s] %s%n", type, date, hour, message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + date + ".txt", true))) {
            writer.write(content);
            System.out.println("Entrou na estrutura");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
