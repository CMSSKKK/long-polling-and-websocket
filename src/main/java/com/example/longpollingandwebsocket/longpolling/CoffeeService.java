package com.example.longpollingandwebsocket.longpolling;

import org.springframework.stereotype.Service;

@Service
public class CoffeeService {

    private static final String COMPLETION_MESSAGE = "%s가 완성되었습니다. 가격은 %d입니다.";
    private static final String ERROR_MESSGAE = "주문을 다시 해주세요.";

    public String makeCoffee(String name) {
        Coffee coffee = Coffee.getCoffee(name);
        try {
            Thread.sleep(coffee.getTime());
        } catch (InterruptedException e) {
            return ERROR_MESSGAE;
        }
        return String.format(COMPLETION_MESSAGE, coffee.getName(), coffee.getCost());
    }
}
