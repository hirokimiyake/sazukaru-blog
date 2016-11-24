/**
 *
 */
package tokyo.sazukaru.filter;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import jp.co.eatsmart.framework.LogManager;
import jp.co.eatsmart.framework.UserManager;
import jp.co.eatsmart.framework.filter.FilterUtil;

/**
 * @author
 *
 */
public class AutoLoginFilter implements Filter {

	private List<Pattern> except;
	private List<Pattern> check;

	/* (非 Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException {

		HttpServletRequest hsr = (HttpServletRequest)request;

		String checkPath = hsr.getRequestURI().substring(hsr.getContextPath().length());

		if (UserManager.getInstance().getUser()!=null){
			chain.doFilter(request, response);
			return;
		}

		if (matches(checkPath,except)){
			chain.doFilter(request, response);
			return;
		}
		
		boolean autoLogin = false;
//		try {
//			autoLogin = AutoLogin.doAutoLogin();
			chain.doFilter(request, response);
//		} catch (InvalidAutoLoginException e) {
//			LogManager.trace(e);
//		} catch (ServerException e) {
//			throw new ServletException(e);
//		}
		return;
	}

	public static boolean matches(String url,List<Pattern> list){
		LogManager.debug("check except auth:"+url);
		for(Pattern p:list){

			if(p.matcher(url).matches()){
				LogManager.debug("hit except pattern:"+p.pattern());
				return true;
			}
		}
		return false;
	}

	/* (非 Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.except = FilterUtil.getInitParameter(filterConfig,"except");
		this.check = FilterUtil.getInitParameter(filterConfig,"check");
	}

	/* (非 Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}

}
