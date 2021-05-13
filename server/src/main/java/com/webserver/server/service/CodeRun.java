package com.webserver.server.service;

/**
 * @Author: Tsuhang Liang(Nero Ransom) CUG
 * @Date: 2021/5/5 6:26
 * @Description
 **/
public interface CodeRun {
    void makeFile(String filename);
    void compile(); //编译
    String exc();   //执行返回执行结果(含报错)
}


