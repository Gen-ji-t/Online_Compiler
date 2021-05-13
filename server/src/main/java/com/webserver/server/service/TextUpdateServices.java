package com.webserver.server.service;

import com.webserver.server.domain.TextUpdateMapper;
import com.webserver.server.domain.TextUpdatePOJO;
import com.webserver.server.domain.UserLoginMapper;
import com.webserver.server.domain.UserLoginPOJO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: Tsuhang Liang(Nero Ransom) CUG
 * @Date: 2021/5/14 5:50
 * @Description
 **/
public class TextUpdateServices {
    @Autowired
    TextUpdateMapper textUpdateMapper;

    public List<TextUpdatePOJO> queryAll() {
        return textUpdateMapper.queryAll();
    }


    public int add(TextUpdatePOJO userLogin) {
        return textUpdateMapper.add(userLogin);
    }


    public TextUpdatePOJO queryByName(String username) {
        return textUpdateMapper.queryByName(username);
    }

    public boolean service(String code,String lang){return true;}
}