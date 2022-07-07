package com.example.longpollingandwebsocket.websocket;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpOutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageHandlingController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) {
        String time = new SimpleDateFormat("HH:MM").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
