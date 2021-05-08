package com.muhang.controller;

import com.alibaba.fastjson.JSONObject;
import com.muhang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import orm.base.BaseController;
import com.muhang.service.HelloService;


/**
 * 示例Controller
 *
 * @author 26061
 */
@Controller
@Scope("prototype")
public class HelloController extends BaseController {

    @Autowired
    HelloService helloService;

    /**
     * 默认方法
     */
    @RequestMapping(value = "/hello.do")
    public JSONObject doHello(User user) throws Exception {
        //throw new ClassNotFoundException("错啦！")  ;\

        return helloService.getUser(user);
    }

    @RequestMapping(value = "/test.do")
    public String testPage() throws Exception {
        return "test";
    }
}

