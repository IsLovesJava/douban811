package com.pan.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TVController {
    @GetMapping(value = "/tv")
    public String defaultPath() {
        return "forward:/page/tv.html";
    }
}
