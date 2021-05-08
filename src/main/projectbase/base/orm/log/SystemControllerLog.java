package orm.log;

import java.lang.annotation.*;

/**
 * Controller层日志接口注解
 * User: 汪超.
 * Date：2016/7/15
 * Time：12:18
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
	String description() default "";
}

