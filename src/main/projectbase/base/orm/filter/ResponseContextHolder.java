package orm.filter;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局拦截器 response操作类
 * User: 汪超
 * Date：2016/7/8
 * Time：14:52
 */
public class ResponseContextHolder {

	private static final ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();
	
	public static void setResponse(HttpServletResponse response) {  
        responseLocal.set(response);  
    } 
	public static HttpServletResponse getResponse() {  
        return (HttpServletResponse)responseLocal.get();  
    }
}
