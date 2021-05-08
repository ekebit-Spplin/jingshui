package orm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseInjectionFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		ResponseContextHolder.setResponse((HttpServletResponse) response);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
