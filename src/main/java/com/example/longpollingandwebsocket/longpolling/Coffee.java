package com.example.longpollingandwebsocket.longpolling;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Coffee {

    AMERICANO("Americano", 4500L, 10000L),
    CAFFE_LATTE("CaffeLatte", 5000L, 3000L),
    MIX_COFFEE("커피는 맥심", 1000L, 500L);

    private final String name;
    private final Long cost;
    private final Long time;

    public static Coffee getCoffee(String name) {
        if (name.trim().equalsIgnoreCase(AMERICANO.name)) {
            return AMERICANO;
        }

        if(name.trim().equalsIgnoreCase(CAFFE_LATTE.name)) {
            return CAFFE_LATTE;
        }

        return MIX_COFFEE;
    }

}
