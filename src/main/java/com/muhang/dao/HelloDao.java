package com.muhang.dao;


import com.muhang.entity.User;
import orm.base.BasePageInfo;

public interface HelloDao {

    public BasePageInfo<User> queryUser(User user) throws Exception;

}
