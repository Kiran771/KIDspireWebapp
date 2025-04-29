package com.kidspire.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;


/**
 * @author kiransaud 23048603
 * Utility class for managing HTTP cookies.
 * Provides methods to add, retrieve, and delete cookies in a web application.
 */
public class CookiesUtil {	
	
	
	/**
     * Adds a new cookie to the HTTP response
     * 
     * @param response the HttpServletResponse object to add the cookie to
     * @param name the name of the cookie
     * @param value the value of the cookie
     * @param maxAge the maximum age of the cookie in seconds
     */
	
	public static void addCookie(HttpServletResponse response,String name,String value, int maxAge){ 
		Cookie cookie=new Cookie(name,value);
		cookie.setMaxAge(maxAge);
		cookie.setPath("/");
		response.addCookie(cookie);
		System.out.println("Cookie added: " + name + " = " + value + ", MaxAge = " + maxAge + " seconds");
	}
	
	/**
     * Retrieves a cookie by its name from the HTTP request
     * 
     * @param request the HttpServletRequest object containing the cookies
     * @param name the name of the cookie to retrieve
     * @return the Cookie object with the specified name, or null if not found
     */
	public static Cookie getCookie(HttpServletRequest request,String name) {
		if(request.getCookies()!=null) {
			return Arrays.stream(request.getCookies())
					.filter(cookie->name.equals(cookie.getName()))
					.findFirst()
					.orElse(null);
		}
		return null;
	}
	
	
	/**
     * Deletes a cookie by setting its value to null and max age to 0
     * 
     * @param response the HttpServletResponse object to add the deletion cookie to
     * @param name the name of the cookie to delete
     */
	public static void deleteCookie(HttpServletResponse response,String name) {
		Cookie cookie=new Cookie(name,null);
		
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
}
