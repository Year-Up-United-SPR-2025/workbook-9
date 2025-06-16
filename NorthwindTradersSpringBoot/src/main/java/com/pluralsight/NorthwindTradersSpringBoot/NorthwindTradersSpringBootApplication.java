package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

    private static Console console = new Console();
    private static ApplicationContext appContext;

    public static void main(String[] args) {
        appContext = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);

    }
}