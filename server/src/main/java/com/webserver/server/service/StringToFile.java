package com.webserver.server.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StringToFile {
    public StringToFile(String workdir,String lang,String code) {
        FileOutputStream toFile = null;
        String b="\r\n";
        code+=b;
        try {
            toFile = new FileOutputStream(new File(workdir+"temp."+lang));
            toFile.write(code.getBytes(StandardCharsets.UTF_8));
            toFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

