package orm.watched;

import com.alibaba.fastjson.JSONObject;

/**
 * 觀察者接口
 * Created by wangchao on 16/9/1.
 */
public interface Observer {
    /**
     * 更新操作
     */
    public void update(Subject subject, Object object, String methodName) throws Exception;

}
