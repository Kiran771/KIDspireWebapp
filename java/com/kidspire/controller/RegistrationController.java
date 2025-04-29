package com.kidspire.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import com.kidspire.util.ValidationUtil;
import com.kidspire.model.UserModel;
import com.kidspire.service.RegisterService;

import com.kidspire.util.PasswordUtil;


/**
 * @author kiransaud 3048603
 * Handles user registration by displaying the form and processing submissions.
 * Validates input, encrypts passwords, registers users, and manages errors.
 * Mapped to "/registrationController".
 * 
 */


@WebServlet(asyncSupported = true, urlPatterns = 
{ "/registrationController"
		
})
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final RegisterService registerService;
	
    public RegistrationController() {
        super();
        this.registerService=new RegisterService();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/pages/registration.jsp").forward(request, response);
	}

	/**
	 * Handles POST requests for the registration form.
	 * It validates the input, encrypts the password, attempts to register the user, and routes accordingly.
	 *
	 * @param request  HttpServletRequest object containing form input
	 * @param response HttpServletResponse object
	 * @throws ServletException
	 * @throws IOException
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isValid=validationRegistrationForm(request);
		
		if (!isValid) {
			System.out.println("Validation Errors!");
			handleError(request, response, "Please correct the highlighted errors.");
			return;
		}
		
		String password=request.getParameter("password");
		String userName=request.getParameter("username");
		String encryptedPassword = PasswordUtil.encrypt(userName, password);
		
		UserModel userModel = new UserModel(
	            request.getParameter("username"),
	            request.getParameter("firstName"),
	            request.getParameter("lastName"),
	            LocalDate.parse(request.getParameter("birthdate")),
	            request.getParameter("contactNumber"),
	            request.getParameter("email"),
	            encryptedPassword
	            
	        );

		Boolean isAdded=registerService.addUser(userModel);
		if (isAdded == null) {
			
			 handleError(request, response, "Registration failed. Please try again.");
		}
		else if(isAdded) {
			request.removeAttribute("error");
			request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
		}else {
			
			 handleError(request, response, "Registration failed. Please try again.");
		}
	}
	
	
	/**
	 * Validates the user input from the registration form.
	 * This method checks for null or empty values, correct format,
	 * password confirmation, and whether the user is at least 18 years old.
	 * 
	 * @param request HttpServletRequest containing form parameters
	 * @return true if all validations pass, false otherwise
	 */
	
	private boolean validationRegistrationForm(HttpServletRequest request) {
		
		request.removeAttribute("usernameError");
	    request.removeAttribute("firstNameError");
	    request.removeAttribute("lastNameError");
	    request.removeAttribute("birthdateError");
	    request.removeAttribute("emailError");
	    request.removeAttribute("contactNumberError");
	    request.removeAttribute("passwordError");
	    request.removeAttribute("confirmPasswordError");
	    
		
		boolean isValid=true;
		
		
		String userName=request.getParameter("username");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String dobStr=request.getParameter("birthdate");
		String email=request.getParameter("email");
		String contactNumber=request.getParameter("contactNumber");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		
		
		if (ValidationUtil.isNullOrEmpty(userName)){
			isValid=false;
			
					
		}
		if (ValidationUtil.isNullOrEmpty(firstName)){
			isValid=false;
						
			
		}
		if (ValidationUtil.isNullOrEmpty(lastName)){
			isValid=false;
						
			
		}
		
		
		if (ValidationUtil.isNullOrEmpty(dobStr)){
			isValid=false;
			
			
		}
		if(ValidationUtil.isNullOrEmpty(email)) {
			isValid=false;
			
			
			
		}
		if (ValidationUtil.isNullOrEmpty(contactNumber)){
			isValid=false;
			
			
		}
		
		if (ValidationUtil.isNullOrEmpty(password)){
			isValid=false;
			
		}
		if(ValidationUtil.isNullOrEmpty(confirmPassword)) {
			isValid=false;
			
		}
		
		if(isValid) {
			LocalDate dob = null;
	        try {
	            dob = LocalDate.parse(dobStr); 
	            if (!ValidationUtil.isAgeAtLeast18(dob)) {
	                isValid = false;
	                
	                
	            }
	        } catch (Exception e) {
	            isValid = false;
	            
	            
	        }
		
			if(!ValidationUtil.isAlphanumericStartWithAlpha(userName)) {
				isValid=false;
				request.setAttribute("usernameError","*Username must start with a letter and contain only letters and numbers" );
				
				
			}
			if(!ValidationUtil.isAlphaValue(firstName)) {
				isValid=false;
				request.setAttribute("firstNameError","*First Name must contain only alphabets" );
				
				
			}
			if(!ValidationUtil.isAlphaValue(lastName)) {
				isValid=false;
				request.setAttribute("lastNameError","*Last Name must contain only alphabets" );
				
				
			}
			if (!ValidationUtil.isAgeAtLeast18(dob)) {
				isValid=false;
				request.setAttribute("birthdateError","*Age must be atleast 18 year old");
				
				
				
			}
			if(!ValidationUtil.isValidContact(contactNumber)) {
				isValid=false;
				request.setAttribute("contactNumberError", "*Contact number must start with 98 and be 10 digits long.");
				
			}
				
			if(!ValidationUtil.isVaildEmail(email)) {
				isValid=false;
				request.setAttribute("emailError","*Must be in the format example@email.com");
				
				
				
			}
			if(!ValidationUtil.isValidPassword(password)) {
				isValid=false;
				request.setAttribute("passwordError","*Password must be 8+ characters, with an uppercase, a number, and a special character");
				
				
			}
			if (!ValidationUtil.isValidConfirmPassword(password,confirmPassword)) {
				isValid=false;
				request.setAttribute("confirmPasswordError","*Password doesnot match");
				
			}
		}
		
		
		return isValid;
		
	}
	
	/**
	 * Handles errors during the registration process by setting error messages
	 * and previously entered values back to the request to repopulate the form.
	 *
	 * @param request  HttpServletRequest object that holds form parameters
	 * @param response HttpServletResponse object
	 * @param message  Error message to be displayed on the registration page
	 * @throws ServletException
	 * @throws IOException
	 */
	private void handleError(HttpServletRequest request, HttpServletResponse response, String message)
			throws ServletException, IOException {
		
		request.setAttribute("error",message);
		 
		 request.setAttribute("username", request.getParameter("username"));
		 request.setAttribute("firstName", request.getParameter("firstName"));
		 request.setAttribute("lastName", request.getParameter("lastName"));
		 request.setAttribute("birthdate",request.getParameter("birthdate"));
		 request.setAttribute("email", request.getParameter("email"));
		 request.setAttribute("contactNumber", request.getParameter("contactNumber"));
		 request.setAttribute("password", request.getParameter("password"));
		 request.setAttribute("confirmPassword", request.getParameter("confirmPassword"));
		 
		 request.getRequestDispatcher("WEB-INF/pages/registration.jsp").forward(request, response);
		
	}
	
	
}
