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
 * AdminDashboardController handles HTTP requests related to the Admin Dashboard view.
 * 
 * On GET request, it fetches all babysitter records, including total count, availability stats,
 * and user statistics such as total users (excluding admin) and recently registered users.
 * The data is forwarded to the "adminDashboard.jsp" page for display.
 * POST requests are delegated to the GET handler to maintain consistent behavior.
 * 
 * Mapped to "/adminDashboard".
 */

@WebServlet(asyncSupported = true, 
urlPatterns = {
		"/adminDashboard" })
public class AdminDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BabysitterManagementService babysitterService;
	private RegisterService registerService;
       
    
    public AdminDashboardController() {
        super();
        babysitterService = new BabysitterManagementService();
        registerService=new RegisterService();
       
    }
    /**
     * Handles GET requests for the Admin Dashboard page.
     * 
     * Retrieves and sets the following data as request attributes:
     * List of all babysitters
     * Total number of babysitters
     * Total number of registered users excluding admin
     * Number of available and unavailable babysitters
     * List of recently registered users
     * 
     * Forwards the request to "WEB-INF/pages/Admin/adminDashboard.jsp".
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<BabysitterModel> babysitters = babysitterService.getAllBabysitters();
			request.setAttribute("babysitters", babysitters);
			request.setAttribute("totalBabysitters",babysitters.size());
			request.setAttribute("totalusers", registerService.getTotalUsersExcludingAdmin());
			request.setAttribute("availableBabysitters", babysitterService.getAvailableBabysitters());
			request.setAttribute("unavailableBabysitters",babysitterService.getUnavailabelBabysitters());
			request.setAttribute("newUsers", registerService.recentUserRegistered());
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
