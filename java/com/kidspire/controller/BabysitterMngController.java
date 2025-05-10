package com.kidspire.controller;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.kidspire.util.ValidationUtil;
import com.kidspire.model.BabysitterModel;
import com.kidspire.service.BabysitterManagementService;


/**
 * @author kiransaud 23048603
 * BabysitterMngController handles requests for the babysitter management page.
 * It forwards both GET and POST requests to "babysitterManagement.jsp".
 * Mapped to "/babysitterMngController".
 * 
 */

@WebServlet(asyncSupported = true, urlPatterns = { "/babysitterMngController" })

public class BabysitterMngController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static BabysitterManagementService babysitterService;
       
    
    public BabysitterMngController() {
        super();
        babysitterService = new BabysitterManagementService();
        
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("edit".equals(action)) {
			
				String babysitterId = request.getParameter("babysitterId");
	       
				try {
					 BabysitterModel babysitter = babysitterService.getBabysitterById(babysitterId);
					 if (babysitter == null) {
			            throw new IllegalArgumentException("Babysitter not found");
			        }
					request.setAttribute("babysitter", babysitter);
			        request.setAttribute("action", "edit");
			        request.getRequestDispatcher("WEB-INF/pages/Admin/babysitterManagement.jsp").forward(request, response);
				} catch (SQLException e) {
					System.err.println("Error in doGet in babysitterMngController: " + e.getMessage());
					e.printStackTrace();
				}
	        
			
		}else {
			request.setAttribute("action", "add");
			request.getRequestDispatcher("WEB-INF/pages/Admin/babysitterManagement.jsp").forward(request, response);
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("delete".equals(action)) {
            deleteBabysitter(request, response);
            return;
        }
		boolean isValid = validationBabysitterDetails(request);
		if(!isValid) {
			handleError(request,response,"Correct the highleted error.");
			return;
			
		}
		
        if ("edit".equals(action)) {
        	updateBabysitter(request,response);
            
        }else {
            addBabysitter(request, response);
        }
	}
	private boolean validationBabysitterDetails(HttpServletRequest request) {
		boolean isValid=true;
	
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String experience=request.getParameter("experience");
		String contactNumber=request.getParameter("contact");
		String email=request.getParameter("email");
		String status=request.getParameter("status");
		
		if(ValidationUtil.isNullOrEmpty(name)) {
			isValid=false;
			
		}
		if(ValidationUtil.isNullOrEmpty(age)){
			isValid=false;
		}	
		if(ValidationUtil.isNullOrEmpty(experience)) {
			isValid=false;
		}
		if(ValidationUtil.isNullOrEmpty(contactNumber)) {
			isValid=false;
		}
		if(ValidationUtil.isNullOrEmpty(email)) {
			isValid=false;
		}
		if(ValidationUtil.isNullOrEmpty(status)) {
			isValid=false;
		}
		
		if(isValid) {
			if(!ValidationUtil.isValidName(name)) {
				isValid=false;
				request.setAttribute("nameError","*Can contain only alpha and space");
			}
			if(!ValidationUtil.validAgeInput(age)) {
				isValid=false;
				request.setAttribute("errorAge", "*Age must be greater than or equal to 18.");
			}
			if(!ValidationUtil.validateExperienceInput(experience)) {
				isValid=false;
				request.setAttribute("errorExperience", "*Must be greater than 1 and less than 21");
				
			}
			if(!ValidationUtil.isValidContact(contactNumber)) {
				isValid=false;
				request.setAttribute("errorContact","*Must contain 10 digit number and start with 98");
				
				
			}
			if(!ValidationUtil.isValidEmail(email)) {
				isValid=false;
				request.setAttribute("errorEmail","*Must be in the format example@email.com ");
			}
					
			
		}
		return isValid;
		
		
	}
	private void addBabysitter(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
		BabysitterModel babysitter=new BabysitterModel(
				request.getParameter("name"),
				Short.parseShort(request.getParameter("age")),
				request.getParameter("experience"),
				request.getParameter("email"),
				request.getParameter("contact"),
				request.getParameter("status")
		);
		babysitterService.addBabysitter(babysitter);
        response.sendRedirect(request.getContextPath() + "/adminDashboard");
		}catch (Exception e) {
            handleError(request, response, "Failed to add babysitter. Please try again.");
        }	

	}
	private void updateBabysitter(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		String babysitterId = request.getParameter("babysitterId");
		if (babysitterId == null || babysitterId.trim().isEmpty()) {
	        handleError(request, response, "Babysitter ID is missing.");
	        return;
	    }

	    BabysitterModel babysitter;
		try {
			babysitter = babysitterService.getBabysitterById(babysitterId);
			 if (babysitter == null) {
			        handleError(request, response, "Babysitter not found.");
			        return;
			    }
			    babysitter.setName(request.getParameter("name"));
			    babysitter.setAge(Short.parseShort(request.getParameter("age")));
			    babysitter.setExperience(request.getParameter("experience"));
			    babysitter.setEmail(request.getParameter("email"));
			    babysitter.setContactNumber(request.getParameter("contact"));
			    babysitter.setStatus(request.getParameter("status"));
			    babysitter.setBabysitterId(Integer.parseInt(babysitterId));

			    babysitterService.updateBabysitter(babysitter);
			    response.sendRedirect(request.getContextPath() + "/adminDashboard");
			  
		} catch (SQLException e) {
			System.err.println("Error during update in controller: " + e.getMessage());
			e.printStackTrace();
		}
	    
	}
	private void deleteBabysitter(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		String babysitterId=request.getParameter("babysitterId");
		if (babysitterId == null || babysitterId.trim().isEmpty()) {
	        handleError(request, response, "Babysitter ID is missing.");
	        response.sendRedirect(request.getContextPath() + "/adminDashboard");
	        return;
	    }
		try {
			babysitterService.deleteBabysitter(babysitterId);
			response.sendRedirect(request.getContextPath() + "/adminDashboard");
		} catch (SQLException e) {
			System.err.println("Error during update in controller: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	private void handleError(HttpServletRequest request, HttpServletResponse response, String message)
			throws ServletException, IOException {
		
		 request.setAttribute("name", request.getParameter("name"));
		 request.setAttribute("age",request.getParameter("age"));
		 request.setAttribute("email", request.getParameter("email"));
		 request.setAttribute("experience", request.getParameter("experience"));
		 request.setAttribute("contact", request.getParameter("contact"));
		 
		 
		 request.getRequestDispatcher("WEB-INF/pages/Admin/babysitterManagement.jsp").forward(request, response);
		
	}
	

}
