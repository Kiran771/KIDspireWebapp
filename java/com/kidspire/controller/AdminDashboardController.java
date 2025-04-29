package com.kidspire.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kiransaud 23048603
 * AdminDashboardController handles requests related to the Admin Dashboard.
 * It forwards both GET and POST requests to the admin dashboard JSP page.
 * Mapped to "/adminDashboard".
 * 
 */

@WebServlet(asyncSupported = true, 
urlPatterns = {
		"/adminDashboard" })
public class AdminDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminDashboardController() {
        super();
       
    }
    /**
     * Handles GET requests to the Admindashboard  page
     * Forwards the request to "WEB-INF/pages/adminDashboard.jsp" for loading
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/pages/Admin/adminDashboard.jsp").forward(request, response);
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
