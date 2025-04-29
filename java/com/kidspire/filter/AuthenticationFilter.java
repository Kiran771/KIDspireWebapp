package com.kidspire.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import com.kidspire.util.CookiesUtil;
import com.kidspire.util.SessionUtil;



/**
 * @author kiransaud 23048603
 * AuthenticationFilter controls access based on user authentication and role.
 * It checks sessions and cookies to allow or redirect users accordingly.
 * Static resources (.png, .css, .js) are excluded from filtering.
 * 
 */


@WebFilter(asyncSupported=true,urlPatterns="/*")
public class AuthenticationFilter implements Filter {
       
    private static final String LOGIN="/loginController";
    private static final String REGISTRATION_FORM="/registrationController";
    private static final String ADMIN_DASHBOARD="/adminDashboard";
    private static final String USER_HOME="/homeController";
    private static final String FAQ="/faqController";
    private static final String ABOUTUS="/aboutusController";
    private static final String BABYSITTER_MANAGEMENT="/babysitterMngController";
    private static final String CONTACT_US="/contactUsController";
    private static final String PROFILE="/profileController";
    private static final String BABYSITTERS="/babysitterController";
    private static final String BLOG="/blogController";
    private static final String LOGOUT = "/logoutController";
    private static final String USER_PROFILE="/userProfile";
    private static final String ROOT="/";
    
    /**
     * Destroys the filter, performing any necessary cleanup.
     * Currently, no cleanup operations are implemented.
     */
    
    public AuthenticationFilter() {
        super();
       
    }

	public void destroy() {
		
	}
	
	/**
	 * Filters incoming HTTP requests to enforce authentication and authorization
	 * Checks if the user is logged in via session attributes and validates their role using cookies
	 * Redirects or allows requests based on the user's role and the requested URI
	 * Static resources (e.g., .png, .jpg, .css, .js) are passed through without checks
	 *
	 * @param request  The ServletRequest object, cast to HttpServletRequest
	 * @param response The ServletResponse object, cast to HttpServletResponse
	 * @param chain    The FilterChain to pass the request and response to the next filter or resource
	 * @throws IOException      If an I/O error occurs during filtering
	 * @throws ServletException If a servlet-related error occurs
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		String lowerCaseUri = uri.toLowerCase();
		
		if (lowerCaseUri.endsWith(".png") || lowerCaseUri.endsWith(".jpg") || lowerCaseUri.endsWith(".css")|| 
				lowerCaseUri.endsWith(".js"))
		{
			chain.doFilter(request, response);
			return;
		}
		
		boolean isLoggedIn = SessionUtil.getAttribute(req, "Username") != null;
		String userRole = CookiesUtil.getCookie(req, "role") != null ? CookiesUtil.getCookie(req, "role").getValue()
				: null;
		
		
		if (!isLoggedIn && userRole != null) {
            CookiesUtil.deleteCookie(res, "role");
            res.sendRedirect(req.getContextPath() + LOGIN);
            return;
        }
		
		if("admin".equals(userRole)) {
			if(uri.endsWith(LOGIN)||uri.endsWith(REGISTRATION_FORM)) {
				res.sendRedirect(req.getContextPath() + ADMIN_DASHBOARD);
				return;
				
				
			}else if(uri.endsWith(ADMIN_DASHBOARD)|| uri.endsWith(BABYSITTER_MANAGEMENT)|| uri.endsWith(PROFILE)||uri.endsWith(LOGOUT)) {
				chain.doFilter(request, response);
				return;
				
			}else 
			{
				res.sendRedirect(req.getContextPath() + ADMIN_DASHBOARD);
				return;
				
			}
			
		} else if("customer".equals(userRole)) {
			
			if(uri.endsWith(LOGIN)|| uri.endsWith(REGISTRATION_FORM)) {
				
				res.sendRedirect(req.getContextPath()+USER_HOME);
				return;
				
				
			}else if(uri.endsWith(USER_HOME)|| uri.endsWith(ABOUTUS) || uri.endsWith(CONTACT_US) || 
					uri.endsWith(BLOG) || uri.endsWith(FAQ) || uri.endsWith(BABYSITTERS)|| uri.endsWith(LOGOUT)||uri.endsWith(USER_PROFILE)) {
				chain.doFilter(request,response);
				return;
				
				
			}else if(uri.endsWith(ADMIN_DASHBOARD)|| uri.endsWith(BABYSITTER_MANAGEMENT)|| uri.endsWith(PROFILE)
					||uri.endsWith(ROOT)) {
				res.sendRedirect(req.getContextPath() + USER_HOME);
				return;
				
			}
		}else {
			
			if(uri.endsWith(LOGIN)|| uri.endsWith(REGISTRATION_FORM)|| uri.endsWith(ROOT)) {
				chain.doFilter(request, response);
				return;
			}
			
			res.sendRedirect(req.getContextPath() + LOGIN);
			return;
			
		}
			
		
		
		
	}
	
	/**
	 * Initializes the filter with the provided configuration.
	 * Currently, no initialization logic is implemented.
	 *
	 * @param fConfig The FilterConfig object containing filter configuration.
	 * @throws ServletException If an error occurs during initialization.
	 */
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
