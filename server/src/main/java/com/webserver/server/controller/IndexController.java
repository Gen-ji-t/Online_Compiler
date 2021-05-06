package com.webserver.server.controller;

import com.webserver.server.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.tools.JavaCompiler;


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
    public String handleFileUpload(@RequestParam(value = "programLanguage",required = true) String codeLang, @RequestParam(value = "code",required = true)String code) {
        System.out.println(codeLang+" "+code);         //打印收到的消息code
        StringToFile string = new StringToFile(workdir,codeLang,code);  //生成相应文件
        if(codeLang.equals("cpp")) {
            CPPCompiler cpp = new CPPCompiler();           //构建编译
            return cpp.run(workdir);
        }else if(codeLang.equals("java")){
            JCompiler java = new JCompiler();
            return java.run(workdir);
        }else if(codeLang.equals("c")){
            CCompiler c = new CCompiler();
            return c.run(workdir);
        }else if(codeLang.equals("py")){
            PythonCompiler python = new PythonCompiler();
            return python.run(workdir);
        }else if(codeLang.equals("go")){
            GoCompiler go = new GoCompiler();
            return go.run(workdir);
        }else{
            CPPCompiler cpp = new CPPCompiler();
            return cpp.run(workdir);
        }
    }
}
