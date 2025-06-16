package com.pluralsight.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLI implements CommandLineRunner {

    @Override
    //... give array of lings or command delimited list
    public void run(String... args) {
        System.out.println("Hello World From CLI");

    }

//    public void doSomething() {
//        run("one", "two", "three");
//    }
}
