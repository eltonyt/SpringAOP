package com.elton.SpringAOP;

import com.elton.SpringAOP.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerMain {

    private static Logger myLogger = Logger.getLogger(AroundWithLoggerMain.class.getName());
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("\nMain Program: AroundDemoApp");
        myLogger.info("Calling getFortune");
        String data = trafficFortuneService.getFortune();
        myLogger.info("\n My Fortune is:" + data);
        myLogger.info("Finished");
        context.close();
    }
}
