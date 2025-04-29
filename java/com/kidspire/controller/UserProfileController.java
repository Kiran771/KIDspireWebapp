package com.kidspire.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kiransaud 23048603
 * UserProfileController handles loading the user profile page
 * It forwards GET and POST requests to the profile view
 * 
 */

@WebServlet(asyncSupported = true, urlPatterns = { "/userProfile" })
public class UserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserProfileController() {
        super();
        
    }

    /**
     * Handles GET requests to the user profile page
     * Forwards the request to "WEB-INF/pages/userProfile.jsp" for loading
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/pages/userProfile.jsp").forward(request, response);
	}
	/**
     * Handles POST requests by forwarding them to the doGet method.
     * This ensures that both GET and POST requests behave the same.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
