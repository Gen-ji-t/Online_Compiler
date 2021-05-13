package com.webserver.server.service;

import com.webserver.server.domain.TextUpdatePOJO;

import java.util.List;

/**
 * @Author: Tsuhang Liang(Nero Ransom) CUG
 * @Date: 2021/5/14 6:03
 * @Description
 **/
public interface OperationService {
    public boolean operation(String code, String lang);
}