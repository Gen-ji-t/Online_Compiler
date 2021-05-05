package com.webserver.server.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class CPPCompiler extends Thread{

    public CPPCompiler(){
    }

    public String compile(){
        // TODO Auto-generated method stub
        Process compile;
        Process run;
        int runnable =0;
        String result = null;

        try {
            //Compile
            compile = Runtime.getRuntime().exec("g++ -o D:\\complier_workspace\\cpp.exe D:\\complier_workspace\\cpp.cpp");//编译a.cpp
            BufferedReader err = new BufferedReader(new InputStreamReader(compile.getErrorStream()));
            String errl;
            if ((errl = err.readLine()) == null)
                runnable = 1;
            while ((errl = err.readLine()) != null) {
                System.out.println(errl);
            }
            err.close();
            compile.waitFor();

            //Thread.sleep((3000));

            //run
            if (runnable == 1){
                run = Runtime.getRuntime().exec("D:\\complier_workspace\\cpp.exe");// 执行编译结果
                //用输入输出流来截取结果
                BufferedReader res = new BufferedReader(new InputStreamReader(run.getInputStream()));
                String resl = null;
                while ((resl = res.readLine()) != null) {
                    System.out.println(resl);
                    result = resl;
                }
                res.close();
                run.waitFor();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
//        File fil = new File("D:\\complier_workspace\\cpp.exe");
//        boolean exist = fil.exists();
//        if(exist) {
//            fil.delete();
//            exist=false;
//        }
//        if(!exist)
//            System.out.println("delete Done");
    }


}