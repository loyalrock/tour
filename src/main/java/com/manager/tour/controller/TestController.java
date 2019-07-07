package com.manager.tour.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @RequestMapping("/get")
    @RequiresAuthentication
    public String get() {
        return "123";
    }
}
