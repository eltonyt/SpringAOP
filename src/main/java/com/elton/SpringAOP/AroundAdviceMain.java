package com.elton.SpringAOP;

import com.elton.SpringAOP.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundAdviceMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        System.out.println("\nMain Program: AroundDemoApp");
        System.out.println("Calling getFortune");
        String data = trafficFortuneService.getFortune();
        System.out.println("\n My Fortune is:" + data);
        System.out.println("Finished");
        context.close();
    }
}
