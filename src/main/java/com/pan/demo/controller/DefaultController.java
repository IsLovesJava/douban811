package com.pan.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class DefaultController {
//    重定向

    @GetMapping(value = "/book")
    public String defaultPath() {
        return "redirect:/book/";
    }
}
