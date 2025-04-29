package com.kidspire.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kidspire.util.CookiesUtil;
import com.kidspire.util.SessionUtil;

/**
 * @author kiransaud 23048603
 * LogoutController handles the logout process for the user
 * It clears the user's session and cookies, and then redirects the user
 * to the login page
 * 
 */

@WebServlet(asyncSupported = true, urlPatterns = { "/logoutController" })
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LogoutController() {
        super();
        
    }
    
    /**
     * Handles POST requests for logging out the user.
     * This method deletes the "role" cookie, invalidates the session,
     * and then redirects the user to the login page.
     *
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet error occurs
     * @throws IOException if an input or output error occurs
     */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookiesUtil.deleteCookie(response, "role");
		SessionUtil.invalidateSession(request);
		response.sendRedirect(request.getContextPath() + "/loginController");
		
	}

}
