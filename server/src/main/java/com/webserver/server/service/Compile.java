package com.webserver.server.service;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Compile {
    static String workdir;
    static String Ltype;
    static FileOutputStream toerr= null;
    static FileOutputStream tores= null;
    static FileWriter codeWrite= null;
    static String code="package main\n" +
            "\n" +
            "import \"fmt\"\n" +
            "\n" +
            "func main() {\n" +
            "    fmt.Println(\"Hello, World!\")\n" +
            "}";

//string(code)->file(.txt)->file(.code)->string(run information)

    public static void main(String[] args) throws IOException {
        workdir ="D:\\_workspace\\";
        Ltype="go";

        try {
            codeWrite = new FileWriter(new File(workdir+"code.txt"));
            toerr= new FileOutputStream(new File(workdir+"errlog.txt"));
            tores= new FileOutputStream(new File(workdir+"reslog.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(Ltype=="c" ){
            renameTo("c",code);
            codeWrite.close();
            compileC();
        }
        else if(Ltype=="c++"){
            renameTo("c++",code);
            compileCpp();
        }
        else if(Ltype=="python"){
            renameTo("python",code);
            compilePython();
        }
        else if(Ltype=="java"){
            renameTo("java",code);
            compileJava();
        }
        else if(Ltype=="go"){
            renameTo("go",code);
            compileGO();
        }

        try {
            toerr.close();
            tores.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void renameTo(String l,String code) throws IOException {//write code to file
       // while(code!=null)//read by line
        codeWrite.write(code);//read done
        codeWrite.close();
        if(l=="c"){                                          //change file name
            File file= new File(workdir+"code.txt");
            file.renameTo(new File(workdir + "c.c"));
        }else if(l=="cpp"){
            File file= new File(workdir+"code.txt");
            file.renameTo(new File(workdir + "cpp.cpp"));
        }else if(l=="python"){
            File file= new File(workdir+"code.txt");
            file.renameTo(new File(workdir + "python.py"));
        }else if(l=="java"){
            File file= new File(workdir+"code.txt");
            file.renameTo(new File(workdir + "java.java"));
        }else if(l=="go"){
        File file= new File(workdir+"code.txt");
        file.renameTo(new File(workdir + "go123.go"));
    }
    }

    public static void compileC(){
        Process compile;
        Process run;
        int runnable=0;

        try {
            //compile c
            compile = Runtime.getRuntime().exec("gcc -o "+workdir+"c.exe "+workdir+"c.c");
            //用输入输出流来截取结果
            BufferedReader err = new BufferedReader(new InputStreamReader(compile.getErrorStream()));

            String errl = null;
            errl = err.readLine();
            if (errl == null)
                runnable = 1;
            while ((errl = err.readLine()) != null) {
                System.out.println(errl);
                errl+="\r\n";
                toerr.write(errl.getBytes(StandardCharsets.UTF_8));
            }
            err.close();
            compile.waitFor();

            //run c
            if (runnable == 1){
                run = Runtime.getRuntime().exec(workdir+"c.exe");
                BufferedReader res = new BufferedReader(new InputStreamReader(run.getInputStream()));
                String resl = null;
                while ((resl = res.readLine()) != null) {
                    System.out.println(resl);
                    resl+="\r\n";
                    tores.write(resl.getBytes(StandardCharsets.UTF_8));
                }
                res.close();
                run.waitFor();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    public static void compileCpp(){
        Process compile;
        Process run;
        int runnable =0;

        try {
            //Compile
            compile = Runtime.getRuntime().exec("g++ -o "+workdir+"cpp.exe "+workdir+"cpp.cpp");//编译a.cpp
            BufferedReader err = new BufferedReader(new InputStreamReader(compile.getErrorStream()));
            String errl;
            if ((errl = err.readLine()) == null)
                runnable = 1;
            while ((errl = err.readLine()) != null) {
                System.out.println(errl);
                errl+="\r\n";
                toerr.write(errl.getBytes(StandardCharsets.UTF_8));
            }
            err.close();
            compile.waitFor();

            //Thread.sleep((3000));

            //run
            if (runnable == 1){
                run = Runtime.getRuntime().exec(workdir+"cpp.exe");// 执行编译结果
                //用输入输出流来截取结果
                BufferedReader res = new BufferedReader(new InputStreamReader(run.getInputStream()));
                String resl = null;
                while ((resl = res.readLine()) != null) {
                    System.out.println(resl);
                    resl+="\r\n";
                    tores.write(resl.getBytes(StandardCharsets.UTF_8));
                }
                res.close();
                run.waitFor();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void compileGO(){
        Process compile;
        Process run;
        int runnable=0;

        try {
            //compile c
            compile = Runtime.getRuntime().exec("go build -o "+ workdir+"go123.exe"+workdir+"go123.go");
            //用输入输出流来截取结果
            BufferedReader err = new BufferedReader(new InputStreamReader(compile.getErrorStream()));

            String errl = null;
            errl = err.readLine();
            if (errl == null)
                runnable = 1;
            while ((errl = err.readLine()) != null) {
                System.out.println(errl);
                errl+="\r\n";
                toerr.write(errl.getBytes(StandardCharsets.UTF_8));
            }
            err.close();
            compile.waitFor();

            //run c
            if (runnable == 1){
                run = Runtime.getRuntime().exec(workdir+"go123.exe");
                BufferedReader res = new BufferedReader(new InputStreamReader(run.getInputStream()));
                String resl = null;
                while ((resl = res.readLine()) != null) {
                    System.out.println(resl);
                    resl+="\r\n";
                    tores.write(resl.getBytes(StandardCharsets.UTF_8));
                }
                res.close();
                run.waitFor();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    public static void compilePython(){
        Process compile;
        try {
            compile= Runtime.getRuntime().exec("python "+workdir+"python.py");// 执行py文件
            //用输入输出流来截取结果

            BufferedReader res = new BufferedReader(new InputStreamReader(compile.getInputStream()));
            BufferedReader err = new BufferedReader(new InputStreamReader(compile.getErrorStream()));


            String resl = null;
            String errl= null;
            while ((errl = err.readLine())!=null){
                System.out.println(errl);
                errl+="\r\n";
                toerr.write(errl.getBytes(StandardCharsets.UTF_8));
            }
            err.close();
            while ((resl = res.readLine()) != null) {
                System.out.println(resl);
                resl+="\r\n";
                tores.write(resl.getBytes(StandardCharsets.UTF_8));
            }
            res.close();
            compile.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void compileJava(){
        Process compile;
        Process run;
        int runnable=0;

        try {
            //compile java
            compile = Runtime.getRuntime().exec("javac "+workdir+"java.java");
            //用输入输出流来截取结果
            BufferedReader err = new BufferedReader(new InputStreamReader(compile.getErrorStream()));

            String errl = null;
            errl = err.readLine();
            if (errl == null)
                runnable = 1;
            while ((errl = err.readLine()) != null) {
                System.out.println(errl);
                errl+="\r\n";
                toerr.write(errl.getBytes(StandardCharsets.UTF_8));
            }
            err.close();
            compile.waitFor();

            //run java
            if (runnable == 1){
                run = Runtime.getRuntime().exec("java "+workdir+"java.java");
                BufferedReader res = new BufferedReader(new InputStreamReader(run.getInputStream()));
                String resl = null;
                while ((resl = res.readLine()) != null) {
                    System.out.println(resl);
                    resl+="\r\n";
                    tores.write(resl.getBytes(StandardCharsets.UTF_8));
                }
                res.close();
                run.waitFor();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

}
