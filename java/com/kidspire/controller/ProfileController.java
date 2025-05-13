package com.kidspire.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.kidspire.model.UserModel;
import com.kidspire.service.ProfileService;
import com.kidspire.util.ValidationUtil;

/**
 * @author kiransaud 23048603
 * 
 * ProfileController is a servlet that handles both GET and POST requests related to the user's profile.
 * On a GET request, it checks if the user is logged in, retrieves the user's profile data from the database,
 * and forwards it to the profile view (JSP page) for display.
 * On a POST request, it validates the submitted profile data (first name, last name, contact number, email),
 * updates the user details in the database if valid, or redisplays the form with validation errors.
 * 
 * This controller ensures that only authenticated users can view or update their profile details.
 * It interacts with ProfileService and uses ValidationUtil for input validation.
 * 
 */

@WebServlet(asyncSupported = true, urlPatterns = { "/profileController" })
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfileService profileService;

       
	/**
	 * Constructor initializes ProfileService instance
	 */
    public ProfileController() {
        super();
        profileService=new ProfileService();
        
    }
    
    /**
	 * Handles GET requests to display the user's profile page.
	 * Checks if the user session is valid, retrieves user data from the database,
	 * and forwards it to the profile JSP page.
	 *
	 * @param request  HTTP request object
	 * @param response HTTP response object
	 * @throws ServletException
	 * @throws IOException
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("Username") == null) {
        	request.getSession(true);
            response.sendRedirect(request.getContextPath() + "/loginController");
            return;
        }
        
        String username = (String) session.getAttribute("Username");
        try {
			UserModel user = profileService.getUserByUsername(username);
			if (user == null) {
                response.sendRedirect(request.getContextPath() + "/loginController");
                return;
            }
			 request.setAttribute("user", user);
			 request.setAttribute("username", username);
	         request.getRequestDispatcher("WEB-INF/pages/Admin/profile.jsp").forward(request, response);
		} catch (SQLException e) {
			response.sendRedirect(request.getContextPath() + "/loginController");
			System.err.println("Error in doGet profileController: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Handles POST requests for updating the user's profile.
	 * Validates input fields, updates the database if valid,
	 * or redisplays the form with error messages.
	 *
	 * @param request  HTTP request containing updated profile data
	 * @param response HTTP response object
	 * @throws ServletException
	 * @throws IOException
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("Username") == null) {
        	request.getSession(true);
            response.sendRedirect(request.getContextPath() + "/loginController");
            return;
        }
		boolean isValid=validateInputDetails(request);
		String username = (String) session.getAttribute("Username");
        request.setAttribute("username", username);
		if(!isValid) {
			handleError(request,response);
			System.out.println("Validation Errors!");
			return;
		}
		
		try {
		UserModel user=new UserModel(
				username,
				request.getParameter("firstName"),
				request.getParameter("lastName"),
				request.getParameter("cNumber"),
				request.getParameter("email")
				
				);
		profileService.updateUserDetails(user);
		response.sendRedirect(request.getContextPath() + "/profileController");
		}catch(SQLException e) {
			System.err.println("SQLException in ProfileController.doPost: " + e.getMessage());
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/loginController");
			
		}	
	}
	
	/**
	 * Validates input values for first name, last name, contact number, and email.
	 * Adds error messages to request attributes if validation fails.
	 *
	 * @param request HTTP request containing form input values
	 * @return true if all inputs are valid; false otherwise
	 */
	private boolean validateInputDetails(HttpServletRequest request) {
		boolean isValid=true;
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String contactNumber=request.getParameter("cNumber");
		String email=request.getParameter("email");
		
		if(!ValidationUtil.isAlphaValue(firstName)) {
			isValid=false;
			request.setAttribute("errorFname","*Must conatin only alphabets.");
				
		}
		if(!ValidationUtil.isAlphaValue(lastName)) {
			isValid=false;
			request.setAttribute("errorLname","*Must conatin only alphabets.");
			
			
		}
		if(!ValidationUtil.isValidContact(contactNumber)) {
			isValid=false;
			request.setAttribute("errorContact","*Contact number must start with 98 and be 10 digits long");
			
			
		}
		if(!ValidationUtil.isValidEmail(email)) {
			isValid=false;
			request.setAttribute("errorEmail","*Must be in the format example@email.com");
			
		}
		return isValid;
	
	}
	
	/**
	 * Handles redisplaying the form with pre-filled input values and error messages
	 * when validation fails.
	 *
	 * @param request  HTTP request containing previous inputs
	 * @param response HTTP response to forward back to profile.jsp
	 * @throws ServletException
	 * @throws IOException
	 */
	 private void handleError(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 
		 request.setAttribute("firstName", request.getParameter("firstName"));
		 request.setAttribute("lastName", request.getParameter("lastName"));
		 request.setAttribute("cNumber", request.getParameter("cNumber"));
		 request.setAttribute("email", request.getParameter("email"));
		 
		 request.getRequestDispatcher("WEB-INF/pages/Admin/profile.jsp").forward(request, response);
		 
	}
 

}
