package com.pluralsight.NorthwindTradersAPI.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NWCountryController {

    @RequestMapping(path = " /country", method = RequestMethod.GET)
    public String index() {
        return "country user page";
    }
}
