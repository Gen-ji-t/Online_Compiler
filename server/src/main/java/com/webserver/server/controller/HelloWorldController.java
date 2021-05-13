package com.webserver.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Tsuhang Liang(Nero Ransom) CUG
 * @Date: 2021/4/29 19:46
 * @Description
 **/

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}