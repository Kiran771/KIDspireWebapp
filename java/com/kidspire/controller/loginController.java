package com.kidspire.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kidspire.service.LoginService;
import com.kidspire.model.UserModel;
import com.kidspire.util.SessionUtil;
import com.kidspire.util.CookiesUtil;

/**
 * @author kiransaud 23048603
 * LoginController handles user login requests
 * It shows the login page for GET requests and processes login for POST requests
 * It manages session and cookies based on login success and user role
 * 
 */

@WebServlet(asyncSupported = true, urlPatterns = { "/loginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	private final LoginService loginService;
	
    public LoginController() {
        this.loginService=new LoginService();
        
    }
    /**
     * Loads the login page when a GET request is made.
     *
     * @param request  HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if a servlet error occurs
     * @throws IOException if an input/output error occurs
     */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
	}
	
	/**
	 * Handles login logic: checks username and password, sets session and cookies, then redirects based on role.
	 * Shows error message if login fails or if something goes wrong.
	 *
	 * @param request  HttpServletRequest with login data
	 * @param response HttpServletResponse for redirection or forwarding
	 * @throws ServletException if a servlet error occurs
	 * @throws IOException if an input/output error occurs
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserModel userModel=new UserModel(userName,password);
		Boolean loginStatus=loginService.loginUser(userModel);
		
		if(loginStatus!=null && loginStatus) {
			
			SessionUtil.setAttribute(request,"Username",userName);
			System.out.println("Session created or accessed. Session ID: " + request.getSession().getId());
		    System.out.println("Session attribute 'Username': " + request.getSession().getAttribute("Username"));

			
			if(userName.equals("admin1")) {
				CookiesUtil.addCookie(response,"role","admin", 5*720);
				System.out.println("Redirecting to dashboard");
				response.sendRedirect(request.getContextPath() + "/adminDashboard");
				
			}else{
				CookiesUtil.addCookie(response,"role","customer", 5*720);
				response.sendRedirect(request.getContextPath()+"/homeController");
			}
		}else {
			
			if(loginStatus==null)
			{
				request.setAttribute("errorMessage","Sorry something went wrong.Please try again later.");
			}else 
			{
				request.setAttribute("errorMessage","Invalid username or password. Please try again.");
				
			}
			request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
		}
		
	}
	
	
	

}