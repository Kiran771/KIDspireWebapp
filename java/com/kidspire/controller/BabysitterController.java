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



/**
 * @author kiransaud 23048603
 * BabysitterController handles HTTP requests related to the Babysitter view page.
 *
 * On GET requests, it retrieves and displays the list of all babysitters.
 * On POST requests, it handles babysitter search by name and displays the filtered results.
 *
 * The controller forwards the request to "babysitter.jsp" located under WEB-INF/pages.
 * 
 * Mapped to "/babysitterController".
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
     * Handles GET requests to the babysitter page.
     * 
     * Retrieves the full list of babysitters from the service layer,
     * sets it as a request attribute, and forwards the request to 
     * "WEB-INF/pages/babysitter.jsp" for rendering.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
	 * Handles POST requests to the babysitter page.
	 * 
	 * Expects a "searchName" parameter from the request, performs a search
	 * for babysitters matching the given name using the service layer,
	 * sets the resulting list as a request attribute, and forwards the 
	 * request to "WEB-INF/pages/babysitter.jsp" to display the results.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
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
