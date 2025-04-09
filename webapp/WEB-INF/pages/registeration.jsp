<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath }/css/registeration.css">
</head>
<body>
	<div class="container">
		<h1 class="title">Registration Form</h1>
		<form action="RegisterController"  method="post">
			<div class="formRow">
				<div class="formgroup">
					<label for="BabysitterId">BabysitterId</label>
					<input type="Number" id="BabysitterId" name="BabysitterId" required>
				</div>
				<div class="formgroup">
					<label for="firstname">First name</label>
					<input type="text" id="firstname" name="firstname" required>
				</div>
			</div>
			<div class="formRow">
				<div class="formgroup">
					<label for="LastName">Last name</label>
					<input type="text" id="lastname" name="lastname" required>
				</div>
				<div class="formgroup">
					<label for="age">Age</label>
					<input type="text" id="age" name="age" required>
				</div>
			</div>
			<div class="formRow">
				<div class="formgroup">
					<label for="experience">Experience</label>
					<input type="text" id="experience" name="experience" required>
					
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
					<label for="Phonenumber">Phone number</label>
					<input type="number" id="Phonenumber" name="Phonenumber" required>
				</div>
				<div class="formgroup">
					<label for="status">Status</label>
					<select id="status" name="status">
						<option value="unavailable">Unavailable</option>
						<option value="available">Available</option>
					</select>
				</div>
			</div>
			<div class="button">
				<button type="submit">Submit</button>
			</div>
			
			
		</form>
	</div>

</body>
</html>