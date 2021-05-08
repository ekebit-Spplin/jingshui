package orm.spring;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import orm.base.BaseController;
import orm.utils.HttpUtils;

import java.util.Date;

/**
 * 请求AOP拦截
 * Created by 张宏 on 2016/5/5.
 */
@Component
@Aspect
public class DispatcherServletAop extends BaseController implements Ordered {

	@Pointcut("execution(* *.*.controller.*.*(..)) || execution(* *.controller.*.*(..)) || target(orm.base.Ex.BaseControllerEx)")
	public void doInit(){
	}


	@Around("doInit()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		//log
		long stime = new Date().getTime();
		//这里是执行的程序
		Object o = joinPoint.proceed();
		logger.info("请求耗时:" + (new Date().getTime() - stime) + "ms\n");
		if (o instanceof JSONObject) {
			HttpUtils.outJson(o.toString());
			return null;
		} else
			return o;
	}

	/**
	 * 优先级为最后
	 *
	 * @return
	 */
	@Override
	public int getOrder() {
		return 999;
	}

	@Before("doInit()")
	public void before(JoinPoint joinPoint) {
	}

	@After("doInit()")
	public void after(JoinPoint joinPoint) {
	}

}
