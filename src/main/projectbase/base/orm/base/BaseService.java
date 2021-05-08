package orm.base;


import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import orm.base.Ex.BaseDaoEx;
import orm.base.Ex.BaseEx;
import wangchao.tools.CreateKey;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;


/**
 * 服务基类
 */
public abstract class BaseService extends BaseEx {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	private TransactionFactory transactionFactory = new JdbcTransactionFactory();

	/**
	 * 获得一个事物
	 *
	 * @return
	 */
	public Transaction getTramsaction() {
		return transactionFactory.newTransaction(sqlSessionTemplate.getConnection());
	}

	/**
	 * 手动回滚事务
	 */
	public void rollBack() {
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	}

	/**
	 * 字典-->具体名称
	 *
	 * @return
	 */
	public String getOrdinalHandlerVal(Object object, String property, String value) {
		return null;
	}

	/**
	 * 获得当前方法名
	 *
	 * @return
	 */
	public String getMethodName() {
		return Thread.currentThread().getStackTrace()[1].getMethodName();
	}

}
