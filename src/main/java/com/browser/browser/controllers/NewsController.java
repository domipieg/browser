package com.browser.browser.controllers;

import com.browser.browser.models.AlteredNews;
import com.browser.browser.services.RestConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @Autowired
    private RestConsumerService restConsumerService;

    @RequestMapping(value = "/news/{country}/{category}")
    public AlteredNews getNewsByCountryAndCategory(@PathVariable("country") String country,
                                                   @PathVariable("category") String category) {

        return restConsumerService.consume(country, category);
    }
}
