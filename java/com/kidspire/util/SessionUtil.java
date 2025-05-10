package com.kidspire.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


/**
 * @author kiransaud 23048603
 * Utility class for managing HTTP session operations.
 * Provides methods to set, get, remove session attributes, and invalidate sessions.
 */
public class SessionUtil {
	
	
	/**
     * Sets an attribute in the HTTP session
     * Creates a new session if one does not exist
     * 
     * @param request the HttpServletRequest object to access the session
     * @param key the name of the attribute to set
     * @param value the value to associate with the attribute
     */
	public static void setAttribute(HttpServletRequest request,String key,Object value) {
		HttpSession session = request.getSession();
        session.setAttribute(key, value);
        System.out.println("Session attribute set: " + key + " = " + value);

	}
	
	 /**
     * Retrieves an attribute from the HTTP session
     * 
     * @param request the HttpServletRequest object to access the session
     * @param key the name of the attribute to retrieve
     * @return the value associated with the attribute, or null if the session does not exist or the attribute is not found
     */
	public static Object getAttribute(HttpServletRequest request,String key) {
		HttpSession session= request.getSession(false);
		if(session!=null) {
			return session.getAttribute(key);
		}
		return null;
	}
	
	/**
     * Removes an attribute from the HTTP session
     * 
     * @param request the HttpServletRequest object to access the session
     * @param key the name of the attribute to remove
     */
	public static void removeAttribute(HttpServletRequest request,String key) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			session.removeAttribute(key);
		}
		
	}
	
	 /**
     * Invalidates the HTTP session, clearing all attributes and making it unusable.
     * 
     * @param request the HttpServletRequest object to access the session
     */
	public static void invalidateSession(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		
	}
	
}
