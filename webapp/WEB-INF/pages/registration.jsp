<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath }/css/registration.css">
</head>
<body>
	<div class="container">
		<img src="${pageContext.request.contextPath}/resources/babysitters.JPG " class="form-image">
		<h1 class="title">Join Our Babysitting Team!</h1>
		<form action="RegisterController"  method="post">
			<div class="formRow">
				<div class="formgroup">
					<label for="firstname">First name</label>
					<input type="text" id="firstname" name="firstname" required>
				</div>
				<div class="formgroup">
					<label for="LastName">Last name</label>
					<input type="text" id="lastname" name="lastname" required>
				</div>
			</div>
			<div class="formRow">
				<div class="formgroup">
					<label for="age">Age</label>
					<input type="number" id="age" name="age" required>
				</div>
				<div class="formgroup">
					<label for="gender">Gender</label>
					<select id="gender" name="gender">
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</div>
			</div>
			<div class="formRow">
				<div class="formgroup">
					<label for="experience">Experience</label>
					<input type="number" id="experience" name="experience" required>
					
				</div>
				<div class="formgroup">
					<label for="Contactnumber">Contact number</label>
					<input type="number" id="Contactnumber" name="Contactnumber" required>
				</div>
				
			</div>
			<div class="formRow">
				<div class="formgroup">
					<label for="Address">Address</label>
					<input type="text" id="Address" name="Address" required>
				</div>
				<div class="formgroup">
					<label for="Status">Status</label>
					<select id="status" name="status">
						<option value="Availabel">Available</option>
						<option value="Unavailable">Unavailable</option>
					</select>
			</div>
		  </div>
			
			<div class="button">
				<button type="submit">Register</button>
			</div>
			
			
		</form>
	</div>

</body>
</html>