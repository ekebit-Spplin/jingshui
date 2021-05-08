package orm.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.dao.DataAccessException;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

/**
 * 统一异常处理
 *
 * @Author wangchao【260619111@qq.com】
 * @Date 2016/5/6 10:19
 */
public class ExceptionHandler implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		Logger log = LoggerFactory.getLogger(getClass());
		log.error("*************************************************");
		log.error("报错类: " + target.getClass().getName());
		log.error("报错方法: " + method.getName());
		for (int i = 0; i < args.length; i++) {
			log.error("arg[" + i + "]:" + args[i]);
		}
		log.error("异常名称: " + ex.getClass().getName());
		log.error("报错信息: " + ex.getMessage());
		log.error("*************************************************");
		throwExByTargetName(target.getClass().getName(), ex);
	}

	/**
	 * 根据类分层抛出异常
	 *
	 * @param clsName 目标类
	 * @param ex      异常
	 */
	private void throwExByTargetName(String clsName, Exception ex) {
		String exMVCStr = "[Others]";
		//Controller层
		if (clsName.indexOf("Controller") != -1) {
			exMVCStr = "[Controller]";
		//Service层
		} else if (clsName.indexOf("Service") != -1) {
			exMVCStr = "[Service]";
		//Dao层
		} else if (clsName.indexOf("Dao") != -1) {
			exMVCStr = "[Dao]";
		}
		throwBusinessEx(ex,exMVCStr);

	}

	private void throwBusinessEx(Exception ex,String exMVCStr){
		if (ex.getClass().equals(DataAccessException.class))
		{
			ex.printStackTrace();
			throw new BusinessException("数据库操作失败！",exMVCStr);
		} else if (ex.getClass().toString().equals(
				NullPointerException.class.toString()))
		{
			ex.printStackTrace();
			throw new BusinessException("调用了未经初始化的对象或者是不存在的对象！",exMVCStr);
		} else if (ex.getClass().equals(IOException.class))
		{
			ex.printStackTrace();
			throw new BusinessException("IO异常！",exMVCStr);
		} else if (ex.getClass().equals(ClassNotFoundException.class))
		{
			ex.printStackTrace();
			throw new BusinessException("指定的类不存在！",exMVCStr);
		} else if (ex.getClass().equals(ArithmeticException.class))
		{
			ex.printStackTrace();
			throw new BusinessException("数学运算异常！",exMVCStr);
		} else if (ex.getClass().equals(ArrayIndexOutOfBoundsException.class))
		{
			ex.printStackTrace();
			throw new BusinessException("数组下标越界!",exMVCStr);
		} else if (ex.getClass().equals(IllegalArgumentException.class))
		{
			ex.printStackTrace();
			throw new BusinessException("方法的参数错误！",exMVCStr);
		} else if (ex.getClass().equals(ClassCastException.class))
		{
			ex.printStackTrace();
			throw new BusinessException("类型强制转换错误！",exMVCStr);
		} else if (ex.getClass().equals(SecurityException.class))
		{
			ex.printStackTrace();
			throw new BusinessException("违背安全原则异常！",exMVCStr);
		} else if (ex.getClass().equals(SQLException.class))
		{
			ex.printStackTrace();
			throw new BusinessException("操作数据库异常！",exMVCStr);
		} else if (ex.getClass().equals(NoSuchMethodError.class))
		{
			ex.printStackTrace();
			throw new BusinessException("方法末找到异常！",exMVCStr);
		} else if (ex.getClass().equals(InternalError.class))
		{
			ex.printStackTrace();
			throw new BusinessException("Java虚拟机发生了内部错误",exMVCStr);
		} else
		{
			ex.printStackTrace();
			throw new BusinessException("程序内部错误，操作失败！" + ex.getMessage(),exMVCStr);
		}
	}
}
