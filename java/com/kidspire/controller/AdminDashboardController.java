package com.kidspire.controller;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.kidspire.model.BabysitterModel;
import com.kidspire.service.BabysitterManagementService;
import com.kidspire.service.RegisterService;

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
	private BabysitterManagementService babysitterService;
	private RegisterService totalUsers;
       
    
    public AdminDashboardController() {
        super();
        babysitterService = new BabysitterManagementService();
        totalUsers=new RegisterService();
       
    }
    /**
     * Handles GET requests to the Admindashboard  page
     * Forwards the request to "WEB-INF/pages/adminDashboard.jsp" for loading
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<BabysitterModel> babysitters = babysitterService.getAllBabysitters();
			request.setAttribute("babysitters", babysitters);
			request.setAttribute("totalBabysitters",babysitters.size());
			request.setAttribute("totalusers", totalUsers.getTotalUsersExcludingAdmin());
			request.setAttribute("availabelBabysitters", babysitterService.getAvailableBabysitters());
			request.getRequestDispatcher("WEB-INF/pages/Admin/adminDashboard.jsp").forward(request, response);
		}catch(SQLException e) {
            throw new ServletException("Database error", e);
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
		
		doGet(request, response);
	}

}
