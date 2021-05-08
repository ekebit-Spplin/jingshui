package com.muhang.entity;

import orm.base.BaseModel;

import java.util.List;

/**
 * 示例Bean
 *
 * @author 26061
 */
public class User extends BaseModel {

    /**
     * 唯一id
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

    private List<UserOrder> userOrders;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<UserOrder> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(List<UserOrder> userOrders) {
        this.userOrders = userOrders;
    }
}
