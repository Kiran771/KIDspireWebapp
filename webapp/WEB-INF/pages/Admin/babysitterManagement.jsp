<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
href="${pageContext.request.contextPath }/css/babysitterManagement.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class='column-group'>
	
			<form action="${pageContext.request.contextPath}/babysitterMngController" method="post">
				<h2>${action == 'edit' ? 'Edit Babysitter' : 'Add Babysitter'}</h2>
           		<input type="hidden" name="action" value="${action}">
            	<c:if test="${action == 'edit'}">
               		 <input type="hidden" name="babysitterId" value="${babysitter.babysitterId}">
           		</c:if>
			
				<label for="Name">Name</label>
			 	<input type="text" id="name" name="name" value="${name != null ? name : babysitter.name}"required>
			 	<c:if test="${not empty nameError}">
					<p class="errorMessage">${nameError}</p>
				</c:if>
				
			 	<label for="age">Age</label>
			 	<input type="number" id="age" name="age" value="${age!=null? age:babysitter.age}"required>
			 	<c:if test="${not empty errorAge}">
					<p class="errorMessage">${errorAge}</p>
				</c:if>
				
				<label for="experience">Experience</label>
			 	<input type="number" id="experience" name="experience" value="${experience!=null? experience:babysitter.experience }"required>
			 	<c:if test="${not empty errorExperience}">
					<p class="errorMessage">${errorExperience}</p>
				</c:if>
				
				<label for="email">Email</label>
			 	<input type="email" id="email" name="email" value="${email!=null? email:babysitter.email}"required>
			 	<c:if test="${not empty errorEmail}">
					<p class="errorMessage">${errorEmail}</p>
				</c:if>
				
			 	<label for="contact">Contact number</label>
			 	<input type="tel" id="contact" name="contact" value="${contact!=null? contact:babysitter.contactNumber}"required>
			 	<c:if test="${not empty errorContact}">
					<p class="errorMessage">${errorContact}</p>
				</c:if>
				
			 	<label for="status">Status</label>
			    <select id="status" name="status">
			       <option value="available" ${babysitter.status == 'available' ? 'selected' : ''}>Available</option>
                   <option value="unavailable" ${babysitter.status == 'unavailable' ? 'selected' : ''}>Unavailable</option>
			    </select>
			    <div class="form-submit">
			    	<button type="submit" class="form-button">
   				 		${action == 'edit' ? 'Update Babysitter' : 'Add Babysitter'}
					</button>
			    </div>
			    
		  </form>
	</div>

</body>
</html>