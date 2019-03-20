package interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import ulti.Helper;

public class AuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie cookie = WebUtils.getCookie(request, "cart");
		if(cookie == null) {
			Helper.addCookie("cart",request, response);	
			/*cookie = new Cookie("cart",Helper.randomString(32));
			cookie.setMaxAge(3600*24*30);
			cookie.setPath(request.getServletContext().getContextPath());
			response.addCookie(cookie);*/
		}
		
		cookie = WebUtils.getCookie(request, "token");
		if(cookie == null) {
			Helper.addCookie("token", request, response);
		}
		return true;
	}

	
}
