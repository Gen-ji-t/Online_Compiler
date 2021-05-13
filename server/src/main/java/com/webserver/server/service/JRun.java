package com.webserver.server.service;

import java.io.*;

public class JRun {

    public JRun() {
    }

    public String run(String workdir) {
        String result = "Hello Java";
        Process compile;
        Process run;
        int runnable = 0;
        try {
            //compile java
            compile = Runtime.getRuntime().exec("javac " + workdir + "temp.java");
            //用输入输出流来截取结果
            BufferedReader err = new BufferedReader(new InputStreamReader(compile.getErrorStream()));

            String errl = null;
            errl = err.readLine();
            if (errl == null)
                runnable = 1;
            while ((errl = err.readLine()) != null) {
                System.out.println(errl);
                result += errl;
            }
            err.close();
            compile.waitFor();

            //run java
            if (runnable == 1) {
                run = Runtime.getRuntime().exec("cmd.exe /c SET CLASSPATH = " + workdir+" \njava " + "temp");
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

        File file = new File(workdir+"temp.class");
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
