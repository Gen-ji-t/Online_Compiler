package com.webserver.server.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StringToFile {
    public StringToFile(String a) {
        FileOutputStream tofile = null;
        String b="\r\n";
        a+=b;
        try {
            tofile = new FileOutputStream(new File("D:\\complier_workspace\\cpp.cpp"));
            tofile.write(a.getBytes(StandardCharsets.UTF_8));
            tofile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

