package com.pluralsight.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AnotherCLI implements CommandLineRunner {
    @Override
    public void run(String ... args) throws Exception{
        System.out.println("Hello From AnotherCLI");
    }
}
