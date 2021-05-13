package com.webserver.server;

import com.webserver.server.service.*;
import org.junit.jupiter.api.Test;

/**
 * @Author: Tsuhang Liang(Nero Ransom) CUG
 * @Date: 2021/5/13 17:53
 * @Description
 **/
public class CodeRunTest {
    @Test
    void testC() {
        new CRun().run("C:\\compiler_workspace\\");
        System.out.println("C run test passed.");
    }

    @Test
    void testJava() {
        new JRun().run("C:\\compiler_workspace\\");
        System.out.println("Java run test passed.");
    }

    @Test
    void testCPP() {
        new CPPRun().run("C:\\compiler_workspace\\");
        System.out.println("CPP run test passed.");
    }

    @Test
    void testGo() {
        new GoRun().run("C:\\compiler_workspace\\");
        System.out.println("go run test passed.");
    }

    @Test
    void testPython() {
        new PythonRun().run("C:\\compiler_workspace\\");
        System.out.println("python run test passed.");
    }

}
