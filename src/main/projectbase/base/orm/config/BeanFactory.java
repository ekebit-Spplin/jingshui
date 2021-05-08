package orm.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 自动创建Bean-工厂
 * User: 汪超.
 * Date：2016/7/20
 * Time：15:00
 */
@Component
public class BeanFactory<T> {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public BeanFactory() {
	}

	/**
	 * 创建Bean实例
	 *
	 * @param c
	 * @return
	 */
	public T getBean(Class c) {
		try {
			if (c != null)
				return (T) c.newInstance();
		} catch (InstantiationException e) {
			logger.error("InstantiationException{}",e);
			return null;
		} catch (IllegalAccessException e) {
			logger.error("IllegalAccessException{}", e);
			return null;
		}
		return null;
	}
}
