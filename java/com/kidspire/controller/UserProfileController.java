package com.kidspire.controller;


import jakarta.servlet.ServletException;
import com.kidspire.service.ProfileService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.kidspire.model.UserModel;

import com.kidspire.util.SessionUtil;
import com.kidspire.util.ValidationUtil;

/**
 * @author kiransaud 23048603
 * 
 * UserProfileController is a servlet that handles GET and POST requests related to the user's profile.
 * 
 * On a GET request, it retrieves the user's profile data from the database using the session's username 
 * and forwards it to the user profile JSP page for viewing.
 * 
 * On a POST request, it validates submitted profile information (first name, last name, contact, email).
 * If valid, it updates the user's data in the database; otherwise, it redisplays the form with error messages.
 * 
 * This servlet ensures that only logged-in users can access or update their profiles.
 * It uses ProfileService for database interactions and ValidationUtil for input validation.
 * 
 */

@WebServlet(asyncSupported = true, urlPatterns = { "/userProfile" })
public class UserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProfileService profileService;
       
	/**
	 * Constructor initializes the ProfileService used for accessing user data.
	 */
    public UserProfileController() {
    	
        super();
        this.profileService=new ProfileService();
        
    }
    
    /**
	 * Handles GET requests to display the current user's profile page.
	 * Validates session, retrieves user data by username, and forwards to the JSP view.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an input or output error occurs
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
        	UserModel user=profileService.getUserByUsername(username);
        	if((user==null)) {
        		response.sendRedirect(request.getContextPath() + "/loginController");
                return;
        	}
        	request.setAttribute("user", user);
			request.setAttribute("username", username);
			request.getRequestDispatcher("WEB-INF/pages/userProfile.jsp").forward(request, response);
        	
        	
        }catch(SQLException e) {
        	response.sendRedirect(request.getContextPath() + "/loginController");
			System.err.println("Error in doGet userProfileController: " + e.getMessage());
			e.printStackTrace();
        }
		
	}
	
	/**
	 * Handles POST requests for updating the user's profile information.
	 * Validates user input, updates the user profile in the database if valid,
	 * or redisplays the form with validation error messages.
	 *
	 * @param request  the HttpServletRequest object containing form inputs
	 * @param response the HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an input or output error occurs
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("Username") == null) {
        	request.getSession(true);
            response.sendRedirect(request.getContextPath() + "/loginController");
            return;
        }
        boolean isValid=validateUserDetails(request);
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
					request.getParameter("phone"),
					request.getParameter("email")
					
					);
			profileService.updateUserDetails(user);
			response.sendRedirect(request.getContextPath() + "/userProfile");
			}catch(SQLException e) {
				System.err.println("SQLException in userProfileController doPost: " + e.getMessage());
	            e.printStackTrace();
	            response.sendRedirect(request.getContextPath() + "/loginController");
				
			}
	}
	 
	 
	 /**
	  * Validates the user's profile input fields (first name, last name, email, contact).
	  * Sets error messages in request attributes for any invalid field.
	  *
	  * @param request the HttpServletRequest object containing form data
	  * @return true if all inputs are valid; false if any validation fails
	  * @throws ServletException if a servlet-specific error occurs
	  */
	
	  private boolean validateUserDetails(HttpServletRequest request) throws ServletException{
		boolean isValid=true;
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String cNumber=request.getParameter("phone");
		 
		if(!ValidationUtil.isAlphaValue(firstName)) {
			isValid=false;
			request.setAttribute("errorFname", "*Only alphabets allowed");
		}
		if(!ValidationUtil.isAlphaValue(lastName)) {
			isValid=false;
			request.setAttribute("errorLname", "*Only alphabets allowed.");
		}
		if(!ValidationUtil.isValidEmail(email)) {
			isValid =false;
			request.setAttribute("errorEmail","*Must be in the format example@email.com");
		}
		if(!ValidationUtil.isValidContact(cNumber)) {
			isValid=false;
			request.setAttribute("errorContact", "*Contact number must start with 98 and be 10 digits long");
		}
		return isValid;
	}
	  
	/**
	* Forwards the request back to the userProfile.jsp page with the previously entered data
	* and any validation error messages if validation fails.
	*
	* @param request  the HttpServletRequest object containing user input
	* @param response the HttpServletResponse object
	* @throws ServletException if a servlet-specific error occurs
	* @throws IOException      if an input or output error occurs
	*/
	
	private void handleError(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 request.setAttribute("firstName", request.getParameter("firstName"));
		 request.setAttribute("lastName", request.getParameter("lastName"));
		 request.setAttribute("phone", request.getParameter("phone"));
		 request.setAttribute("email", request.getParameter("email"));
		 
		 request.getRequestDispatcher("WEB-INF/pages/userProfile.jsp").forward(request, response);
		 
	}
	
	

}
