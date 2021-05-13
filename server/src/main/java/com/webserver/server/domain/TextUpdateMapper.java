package com.webserver.server.domain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author: Tsuhang Liang(Nero Ransom) CUG
 * @Date: 2021/5/13 23:22
 * @Description
 **/


@Mapper
@Repository
public interface TextUpdateMapper {
    //查询
    public List<UserLoginPOJO> queryAll();
    //添加数据
    public int add(UserLoginPOJO userLogin);
    //根据用户名查询数据
    public UserLoginPOJO queryByName(String username);
}