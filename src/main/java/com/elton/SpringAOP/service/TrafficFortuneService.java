package com.elton.SpringAOP.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune() {

        // SIMULATE A DELAY
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // RETURN A FORTUNE
        return "This is a fortune for you!";

    }
}
