/**
 *
 */
package tokyo.sazukaru.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tokyo.sazukaru.common.Constant;
import jp.co.eatsmart.framework.LogManager;
import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.filter.FilterUtil;
import jp.co.eatsmart.util.CheckUtil;
import jp.co.eatsmart.util.TypeUtil;


/**
 */
public class LoginFilter implements Filter {

	private List<Pattern> check;
	private List<Pattern> except;
	private String redirect;

	private String getPath(HttpServletRequest hsr) {
		String reqPath = hsr.getParameter("path");
		String reqLogin = hsr.getParameter("login");
		if(
				!CheckUtil.isNull(reqPath) &&
				!CheckUtil.isNull(reqLogin) &&
				"true".equals(reqLogin)
		){
			return reqPath;
		} else {
			String path = hsr.getRequestURI();
			String query = hsr.getQueryString();
			if (query != null){
				path = path + "?" + query;
			}
			return path;
		}
	}
	/* (非 Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException {
		HttpServletRequest hsr = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		String checkPath = hsr.getRequestURI().substring(hsr.getContextPath().length());

		//スマホログイン用戻りパスパラメータ設定 2012/8/24
		Map<String,String> param = new HashMap<String,String>();
		String path = getPath(hsr);
		param.put("path",path);
		request.setAttribute("loginparam",param);
		// ログイン済みの場合、何もしない
		if(FilterUtil.isLogin()){
			chain.doFilter(request, response);
			return;
		}
		// 対象URL以外の場合、何もしない
		if(!AutoLoginFilter.matches(checkPath,check)){
			chain.doFilter(request, response);
			return;
		}
		// 対象外URLの場合、何もしない
		if(AutoLoginFilter.matches(checkPath,except)){
			chain.doFilter(request, response);
			return;
		}

		// 未ログインの場合、リダイレクト
		try {
			String redirectPath = getRedirectUrl(hsr,redirect);
			try {
				LogManager.audit("[" + hsr.getSession().getId() + "]　★★★アクション【" + hsr.getRequestURI() + "】ログインが必要なためリダイレクトします。 => "+redirectPath);
			} catch(Exception e) {
				//NOP
			}
			res.sendRedirect(redirectPath);
		} catch (ServerException e) {
			throw new ServletException(e);
		}
		return;
	}
	public static String getRedirectUrl(HttpServletRequest request,String redirectUrl) throws ServerException {
		StringBuffer url = new StringBuffer(request.getRequestURL());
		String queryString = request.getQueryString();
		if(!CheckUtil.isNull(queryString)){
			url.append("?").append(queryString);
		}
		StringBuffer sb = new StringBuffer(redirectUrl);
		//StringBuffer sb = new StringBuffer(redirect);
		sb.append("?").append(Constant.REQUEST_KEY_PATH_QUERY).append("=").append(TypeUtil.toURLEncode(url.toString()));
		return sb.toString();
	}

	/**
	 * 初期化処理
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.check = FilterUtil.getInitParameter(filterConfig,"check");
		this.except = FilterUtil.getInitParameter(filterConfig,"except");
		this.redirect = filterConfig.getInitParameter("redirect");
		LogManager.debug("redirect dir:"+this.redirect);
	}

	public void destroy() {
	}

}
