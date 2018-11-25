/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mydasmanager.controller;

import com.github.seratch.jslack.*;
import com.github.seratch.jslack.api.webhook.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriela Garcia
 */
public class Program {

    public static void main(String[] args) {

        try {
            
            String url = "https://hooks.slack.com/services/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";
            
            Payload payload = Payload.builder()
                    .channel("#general")
                    .username("username")
                    .iconEmoji(":smile_cat:")
                    .text("message")
                    .build();
            
            Slack slack = Slack.getInstance();
            WebhookResponse response = slack.send(url, payload);
            
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
