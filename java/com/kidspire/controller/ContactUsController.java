package com.kidspire.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kiransaud 23048603
 * 
 * ContactUsController handles requests for the contactus page.
 * It forwards both GET and POST requests to "contactUs.jsp".
 * Mapped to "/contactUsController"
 * 
 */

@WebServlet(asyncSupported = true, urlPatterns = { "/contactUsController" })
public class ContactUsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ContactUsController() {
        super();
       
    }

    /**
     * Handles GET requests to the contact us page
     * Forwards the request to "WEB-INF/pages/contactUs.jsp" for loading
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/contactUs.jsp").forward(request, response);
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
