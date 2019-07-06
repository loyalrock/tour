package com.manager.tour.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @RequestMapping("/get")
    public String get() {
        return "123";
    }
}
