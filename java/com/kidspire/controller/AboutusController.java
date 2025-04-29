package com.kidspire.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author kiransaud 23048603
 * AboutusController handles requests related to the About Us page.
 * It maps to the URL pattern "/aboutusController" and forwards the request
 * to the corresponding JSP page located under WEB-INF/pages.
 * 
 */


@WebServlet(asyncSupported = true, urlPatterns = { "/aboutusController" })
public class AboutusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AboutusController() {
        super();
       
    }
    
    /**
     * Handles GET requests to the About Us page
     * Forwards the request to "WEB-INF/pages/aboutUs.jsp" for loading
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/aboutUs.jsp").forward(request, response);
	}

	
	/**
     * Handles POST requests by forwarding them to the doGet method
     * This ensures that both GET and POST requests behave the same
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
