package com.pluralsight.NorthwindTradersAPI.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NWController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "World") String name) {
        return "<h1>Hello" + name + " </h1> <p>Welcome to the Northwind Database</p>";
    }
}
