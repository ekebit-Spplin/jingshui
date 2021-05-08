package orm.base;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import orm.base.Ex.BaseEx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Controller基类
 *
 * @author wangchao & 张宏
 */
public abstract class BaseController extends BaseEx {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	//重定向
	protected String REDIRECT = "redirect";

	BaseService baseService;

	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	/**
	 * 获取请求参数
	 *
	 * @param str
	 * @return
	 */
	public String getParameter(String str) {
		return request.getParameter(str);
	}

	/**
	 * 输出代码格式
	 *
	 * @param str
	 */
	public void outJson(String str) {
		response.setContentType("text/json;charset=utf-8");
		try {
			String callback = request.getParameter("callback");
			if (callback != null) {
				response.getWriter().write(callback + "(" + str + ")");
			} else {
				response.getWriter().write(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	/**
	 * 获取request对象参数
	 *
	 * @param beanVal
	 * @return
	 */
	public Object getAttribute(String beanVal) {
		return request.getAttribute(beanVal);
	}

	/**
	 * 重定向
	 *
	 * @param url 请求地址
	 * @param map 请求参数
	 * @return
	 */
	public ModelAndView redirectURL(String url, Map<String, Object> map) {
		return new ModelAndView(REDIRECT + ":" + url, map);
	}

	/**
	 * 重定向
	 *
	 * @param url
	 * @return
	 */
	public ModelAndView redirectURL(String url) {
		return this.redirectURL(url, null);
	}

	/**
	 * 重定向到 控制器 必须为内部
	 *
	 * @param url
	 * @param map
	 * @return
	 */
	public ModelAndView redirectController(String url, Map<String, Object> map) {
		return new ModelAndView(url, map);
	}

}
