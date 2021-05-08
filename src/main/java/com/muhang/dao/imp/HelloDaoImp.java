package com.muhang.dao.imp;

import com.muhang.dao.HelloDao;
import com.muhang.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import orm.base.BaseDao;
import orm.base.BasePageInfo;

/**
 * 示例Dao
 *
 * @author 26061
 */
@Repository
@Scope("prototype")
public class HelloDaoImp extends BaseDao implements HelloDao {

    @Override
    public BasePageInfo<User> queryUser(User user) throws Exception {
        // TODO Auto-generated method stub
        BasePageInfo<User> pageInfo = this.pageQuery("queryUser", user);
        return pageInfo;
    }
}
