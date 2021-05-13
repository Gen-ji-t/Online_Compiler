package com.webserver.server.controller;

import com.webserver.server.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: Tsuhang Liang(Nero Ransom) CUG
 * @Date: 2021/5/5 0:23
 * @Description
 **/

@Controller
public class IndexController {
    private String workdir ="C:\\compiler_workspace\\";

    @GetMapping("/index")
    public String index() {
        return "/index.html";
    }

    @PostMapping("/index")
    @ResponseBody
    public String handleCodeUpload(@RequestParam(value = "programLanguage",required = true) String codeLang, @RequestParam(value = "code",required = true)String code) {
        System.out.println(codeLang+" "+code);         //打印收到的消息code
        StringToFile string = new StringToFile(workdir,codeLang,code);  //生成相应文件
        if(codeLang.equals("cpp")) {
            CPPRun cpp = new CPPRun();           //构建编译
            return cpp.run(workdir);
        }else if(codeLang.equals("java")){
            JRun java = new JRun();
            return java.run(workdir);
        }else if(codeLang.equals("c")){
            CRun c = new CRun();
            return c.run(workdir);
        }else if(codeLang.equals("py")){
            PythonRun python = new PythonRun();
            return python.run(workdir);
        }else if(codeLang.equals("go")){
            GoRun go = new GoRun();
            return go.run(workdir);
        }else{
            CPPRun cpp = new CPPRun();
            return cpp.run(workdir);
        }
    }

    public void handleTextUpdate(String codeLang, String code) {
        System.out.println(codeLang + " " + code);
        StringToFile string = new StringToFile(workdir,codeLang,code);  //生成相应文件
        if(codeLang.equals("cpp")) {
            CPPRun cpp = new CPPRun();           //构建编译
        }else if(codeLang.equals("java")){
            JRun java = new JRun();
        }else if(codeLang.equals("c")){
            CRun c = new CRun();
        }else if(codeLang.equals("py")){
            PythonRun python = new PythonRun();
        }else if(codeLang.equals("go")){
            GoRun go = new GoRun();
        }else{
            CPPRun cpp = new CPPRun();
        }
    }
}
