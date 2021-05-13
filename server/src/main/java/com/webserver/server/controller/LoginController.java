package com.webserver.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Tsuhang Liang(Nero Ransom) CUG
 * @Date: 2021/5/6 5:50
 * @Description
 **/
@Controller
public class LoginController {
    @GetMapping("/")
    public String login() {
        return "login.html";
    }


}
