package com.webserver.server.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoCompiler {

    public GoCompiler() {
    }

    public String run(String workdir) {
        String result = "";
        Process compile;
        try {
//            compile = Runtime.getRuntime().exec("cmd.exe /c mkdir " + workdir + "/main");
//            compile = Runtime.getRuntime().exec("cmd.exe /c move "+workdir+"temp.go "+workdir+"/main/");
            compile = Runtime.getRuntime().exec("go mod init hello");
            compile = Runtime.getRuntime().exec("go run " + workdir + "temp.go");
            //用输入输出流来截取结果

            BufferedReader res = new BufferedReader(new InputStreamReader(compile.getInputStream()));
            BufferedReader err = new BufferedReader(new InputStreamReader(compile.getErrorStream()));

            String resl = null;
            String errl = null;
            while ((errl = err.readLine()) != null) {
                System.out.println(errl);
                result += errl;
            }
            err.close();
            while ((resl = res.readLine()) != null) {
                System.out.println(resl);
                result += resl;
            }
            res.close();
            compile.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        File fil = new File(workdir + "temp.go");
//        boolean exist = fil.exists();
//        if (exist) {
//            fil.delete();
//            exist = false;
//        }
//        if (!exist) {
//            System.out.println("Delete Done");
//        }
        return result;
    }
}