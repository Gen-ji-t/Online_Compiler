package com.webserver.server.controller;

import com.webserver.server.service.CPPCompiler;
import com.webserver.server.service.StringToFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: Tsuhang Liang(Nero Ransom) CUG
 * @Date: 2021/5/5 0:23
 * @Description
 **/

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @PostMapping("/")
    @ResponseBody
    public String handleFileUpload(@RequestParam(value = "programLanguage",required = true) String language, @RequestParam(value = "code",required = true)String code) {
        System.out.println(language+" "+code);         //打印收到的消息code
        StringToFile string = new StringToFile(code);  //生成相应文件
        CPPCompiler cpp = new CPPCompiler();           //构建编译
        return cpp.compile();
    }
}
