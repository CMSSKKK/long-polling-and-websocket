package com.example.longpollingandwebsocket.websocket;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OutputMessage {

    private final String from;
    private final String text;
    private final String time;


}
