package br.com.mydasmanager.controller;

import br.com.mydasmanager.view.Login;
import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) {
        new Login();
        sendMessage();
    }
    
    public static void sendMessage(){
        try {
            
            String url = "https://hooks.slack.com/services/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";
            
            Payload payload = Payload.builder()
                    .channel("#random")
                    .username("Stalker Bot")
                    .iconEmoji(":smile_cat:")
                    .text("Uma solicitação de login foi iniciada.")
                    .build();
            
            Slack slack = Slack.getInstance();
            WebhookResponse response = slack.send(url, payload);
            EstruturalLog.log("INFO", response.getMessage(), url);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
