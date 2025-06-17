package com.pluralsight.NorthwindTradersAPI.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NWController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "World") String country) {
        return "<h1>Hello " + country + "</h1> <p>Welcome to the Northwind Database</p>";
    }
}
