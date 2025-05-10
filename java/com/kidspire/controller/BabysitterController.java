package com.kidspire.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.kidspire.service.BabysitterManagementService;
import com.kidspire.model.BabysitterModel;


/**
 * @author kiransaud 23048603
 * BabysitterController handles GET and POST requests for the babysitter page.
 * It forwards the request to "babysitter.jsp" for displaying the page content.
 * Mapped to "/babysitterController".
 * 
 */


@WebServlet(asyncSupported = true, urlPatterns = { "/babysitterController" })
public class BabysitterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BabysitterManagementService babysitterService;
       
    
    public BabysitterController() {
        super();
        babysitterService=new BabysitterManagementService();
       
    }
    /**
     * Handles GET requests to the babysitter page
     * Forwards the request to "WEB-INF/pages/babysitter.jsp" for loading
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            List<BabysitterModel> babysitters = babysitterService.getBabysitters();
            request.setAttribute("babysitters", babysitters);
            request.getRequestDispatcher("WEB-INF/pages/babysitter.jsp").forward(request, response);
        } catch (SQLException e) {
            System.err.println("Error fetching babysitters: " + e.getMessage());
            e.printStackTrace();
        }
		
		
	}

	/**
     * Handles POST requests by forwarding them to the doGet method.
     * This ensures that both GET and POST requests behave the same.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String searchName=request.getParameter("searchName");
			List<BabysitterModel> babysitters = babysitterService.searchByName(searchName);
			request.setAttribute("babysitters", babysitters);
			request.getRequestDispatcher("WEB-INF/pages/babysitter.jsp").forward(request, response);
		} catch (SQLException e) {
			 System.err.println("Error searching babysitters: " + e.getMessage());
	            e.printStackTrace();
		}
		
	}

}
