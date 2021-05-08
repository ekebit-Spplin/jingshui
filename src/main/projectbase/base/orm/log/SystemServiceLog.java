package orm.log;

import java.lang.annotation.*;

/**
 * 业务层日志记录接口注解
 * User: 汪超.
 * Date：2016/7/15
 * Time：12:19
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
	String description() default "";
}
