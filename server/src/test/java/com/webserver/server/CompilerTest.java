package com.webserver.server;

import com.webserver.server.service.*;
import org.junit.jupiter.api.Test;

/**
 * @Author: Tsuhang Liang(Nero Ransom) CUG
 * @Date: 2021/5/13 17:53
 * @Description
 **/
public class CompilerTest {
    @Test
    void testC() {
        new CCompiler().run("C:\\compiler_workspace\\");
        System.out.println("C compiler test passed.");
    }

    @Test
    void testJava() {
        new JCompiler().run("C:\\compiler_workspace\\");
        System.out.println("Java test passed.");
    }

    @Test
    void testCPP() {
        new CPPCompiler().run("C:\\compiler_workspace\\");
        System.out.println("CPP test passed.");
    }

    @Test
    void testGo() {
        new GoCompiler().run("C:\\compiler_workspace\\");
        System.out.println("go compiler test passed.");
    }

    @Test
    void testPython() {
        new PythonCompiler().run("C:\\compiler_workspace\\");
        System.out.println("python compiler test passed.");
    }

}
