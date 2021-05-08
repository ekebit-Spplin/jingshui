package orm.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import orm.filter.ResponseContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * 数据传输工具类(Spring)
 * User: 汪超.
 * Date：2016/7/8
 * Time：14:44
 */
public class HttpUtils {

	/**
	 * 获取当前请求的HttpServletRequest
	 * @return
	 */
	public static HttpServletRequest getCurrentHttpServletRequest(){
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		if (requestAttributes != null) {
			return ((ServletRequestAttributes) requestAttributes).getRequest();
		}else{
			throw new IllegalStateException("Current HttpServletRequest Not Found");
		}
	}

	/**
	 * 获取当前响应HttpServletResponse
	 * @return
	 */
	public static HttpServletResponse getCurrentHttpServletResponse(){
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		if (requestAttributes != null) {
			return ((ServletRequestAttributes) requestAttributes).getResponse();
		}else{
			throw new IllegalStateException("Current HttpServletRequest Not Found");
		}
	}

	/**
	 * 获取user-agent
	 * @return
	 */
	public static String getUserAgent(){
		return getCurrentHttpServletRequest().getHeader("user-agent");
	}

	/**
	 * 判断user-agen匹配
	 * @param userAgent
	 * @return
	 */
	public static boolean userAgentLike(String userAgent){
		String real = getUserAgent();
		if(real!=null&&userAgent!=null){
			real = real.replaceAll("\\s", "").toLowerCase();
			return real.indexOf(userAgent.replaceAll("\\s", "").toLowerCase())!=-1;
		}else
			return false;
	}

	/**
	 * 判断user-agen相等
	 * @param userAgent
	 * @return
	 */
	public static boolean userAgentEqual(String userAgent){
		String real = getUserAgent();
		if(real!=null)
			return real.equals(userAgent);
		else
			return false;
	}

	/**
	 * response写数据
	 * @param data
	 * @throws IOException
	 */
	public static void outJson(String data) throws IOException {
		HttpServletResponse response = getCurrentHttpServletResponse();
		HttpServletRequest request = getCurrentHttpServletRequest();
		response.setContentType("text/json;charset=utf-8");
		try {
			String callback = request.getParameter("callback");
			if (callback != null) {
				response.getWriter().write(callback + "(" + data + ")");
			} else {
				response.getWriter().write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
