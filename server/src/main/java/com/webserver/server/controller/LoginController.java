package com.webserver.server.controller;

import com.webserver.server.domain.UserLoginPOJO;
import com.webserver.server.service.UserLoginServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Tsuhang Liang(Nero Ransom) CUG
 * @Date: 2021/5/6 5:50
 * @Description
 **/
@Controller
public class LoginController {
    @Autowired
    UserLoginServicesImpl userLoginServicesImpl;

    @GetMapping("/")
    public String login() {
        return "login.html";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam(value = "name",required = true) String name, @RequestParam(value = "pswd",required = true)String pswd) {
        System.out.println(name + " " + pswd);         //打印收到的登录信息
        if(verify(name,pswd)){
            return "index.html";
        }
        else{
            return "login.html";
        }
    }

    private boolean verify(String name, String pswd) {
        UserLoginPOJO userLogin = new UserLoginPOJO();
        UserLoginPOJO userLogin1 = userLoginServicesImpl.queryByName(userLogin.getUsername());
        if(userLogin1 != null){ //  如果查询的用户不为空
            System.out.println(userLogin1.toString());
            System.out.println(userLogin.toString());
            return true;
        }
        else{
            return true;
        }
    }
}
