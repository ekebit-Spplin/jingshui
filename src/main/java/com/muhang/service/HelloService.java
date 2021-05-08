package com.muhang.service;

import com.alibaba.fastjson.JSONObject;
import com.muhang.entity.User;

public interface HelloService {

    /**
     * 获取用户信息
     *
     * @param user
     * @return
     * @throws Exception
     */
    public JSONObject getUser(User user) throws Exception;
}
