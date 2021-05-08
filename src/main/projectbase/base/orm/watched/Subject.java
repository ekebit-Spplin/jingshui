package orm.watched;

/**
 * 被觀察者接口
 * Created by wangchao on 16/9/1.
 */
public interface Subject {

    /**
     * 注册观察者
     *
     * @param obj
     */
    public void register(Observer obj);

    /**
     * 删除观察者
     *
     * @param obj
     */
    public void unregister(Observer obj);

    /**
     * 通知观察者
     *
     * @param object 传递的参数
     */
    public void notifyObservers(Object object, String methodName) throws Exception;

}
