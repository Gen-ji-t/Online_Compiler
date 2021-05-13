package com.webserver.server.service;

import com.webserver.server.domain.UserLoginMapper;
import com.webserver.server.domain.UserLoginPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Tsuhang Liang(Nero Ransom) CUG
 * @Date: 2021/5/13 23:38
 * @Description
 **/

@Service
public class UserLoginServicesImpl {
    @Autowired
    UserLoginMapper userLoginMapper;

    public List<UserLoginPOJO> queryAll() {
        return userLoginMapper.queryAll();
    }


    public int add(UserLoginPOJO userLogin) {
        return userLoginMapper.add(userLogin);
    }


    public UserLoginPOJO queryByName(String username) {
        return userLoginMapper.queryByName(username);
    }

}
