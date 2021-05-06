package com.webserver.server.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class CPPCompiler{

    public CPPCompiler(){
    }

    public String run(String workdir){
        Process compile;
        Process run;
        int runnable =0;
        String result = "";

        try {
            //Compile
            compile = Runtime.getRuntime().exec("g++ -o "+workdir+"temp.exe "+workdir+"temp.cpp");//编译a.cpp
            BufferedReader err = new BufferedReader(new InputStreamReader(compile.getErrorStream()));
            String errl;
            if ((errl = err.readLine()) == null)
                runnable = 1;
            while ((errl = err.readLine()) != null) {
                System.out.println(errl);
                result += errl;
            }
            err.close();
            compile.waitFor();

            //Thread.sleep((3000));

            //run
            if (runnable == 1){
                run = Runtime.getRuntime().exec(workdir+"temp.exe");// 执行编译结果
                BufferedReader res = new BufferedReader(new InputStreamReader(run.getInputStream()));
                String resl = null;
                while ((resl = res.readLine()) != null) {
                    System.out.println(resl);
                    result += resl;
                }
                res.close();
                run.waitFor();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File file = new File(workdir+"temp.exe");
        boolean exist = file.exists();
        if(exist) {
            file.delete();
            exist=false;
        }
        if(!exist) {
            System.out.println("delete Done");
        }
        return result;
    }
}