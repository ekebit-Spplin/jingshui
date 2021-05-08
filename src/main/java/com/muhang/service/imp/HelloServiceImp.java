package com.muhang.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.muhang.dao.HelloDao;
import com.muhang.entity.User;
import com.muhang.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import orm.base.BasePageInfo;
import orm.base.BaseService;

/**
 * 示例Service
 *
 * @author 26061
 */
@Service
@Scope("prototype")
public class HelloServiceImp extends BaseService implements HelloService {

    @Autowired
    HelloDao helloDao;

    @Override
    public JSONObject getUser(User user) throws Exception {
        BasePageInfo<User> pageInfo = helloDao.queryUser(user);

        pageInfo.addRemove("passWord", "userId");
        return codeData(pageInfo);
    }
}
