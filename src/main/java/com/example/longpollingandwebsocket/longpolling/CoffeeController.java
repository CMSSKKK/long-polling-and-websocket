package com.example.longpollingandwebsocket.longpolling;

import lombok.RequiredArgsConstructor;
import org.springframework.core.task.support.ExecutorServiceAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequiredArgsConstructor
public class CoffeeController {

    private final ExecutorService barista = Executors.newFixedThreadPool(5);
    private final CoffeeService coffeeService;

    @GetMapping("/coffee")
    public DeferredResult<String> orderOne(@RequestParam String coffeeName) {
        DeferredResult<String> output = new DeferredResult<>();
        barista.execute(() -> output.setResult(coffeeService.makeCoffee(coffeeName)));
        return output;
    }
}
