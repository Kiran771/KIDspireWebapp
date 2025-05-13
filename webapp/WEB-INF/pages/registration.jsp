<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/registration.css">
</head>
<body>
	<div class="registrationContainer">
		<div class="registrationDesignSpc">

			<img
				src="${pageContext.request.contextPath}/resources/registrationImg.jpg">
			<h1>Already have an account?</h1>
			<a href="${ pageContext.request.contextPath }/loginController"><button>Login
					now</button></a>


		</div>
		<div class="fieldSpace">

			<h1>Registration</h1>
			<c:if test="${not empty error}">
				<p class="invalidError">${error}</p>
			</c:if>
			<form
				action="${pageContext.request.contextPath}/registrationController"
				method="post">
				<div class=rowGroup>
					<div class=columnGroup>
						<label for="username"> Username</label> <input type="text"
							id="username" name="username" value="${username}" required>
						<c:if test="${not empty usernameError}">
							<p class="errorMessage">${usernameError}</p>
						</c:if>
					</div>
					<div class=columnGroup>
						<label for="firstname">First Name</label> <input type="text"
							id="firstName" name="firstName" value="${firstName}" required>
						<c:if test="${not empty firstNameError}">
							<p class="errorMessage">${firstNameError}</p>
						</c:if>

					</div>
				</div>
				<div class=rowGroup>
					<div class=columnGroup>
						<label for="lastName">Last Name</label> <input type="text"
							id="lastName" name="lastName" value="${lastName}" required>
						<c:if test="${not empty lastNameError}">
							<p class="errorMessage">${lastNameError}</p>
						</c:if>
					</div>
					<div class=columnGroup>
						<label for="dob">Date of birth</label> <input type="date" id="dob"
							name="birthdate" value="${birthdate}" required>
						<c:if test="${not empty birthdateError}">
							<p class="errorMessage">${birthdateError}</p>
						</c:if>

					</div>
				</div>

				<div class=rowGroup>
					<div class=columnGroup>
						<label for="contactNumber">Contact Number</label> <input
							type="text" id="contactNo" name="contactNumber"
							value="${contactNumber}" required>
						<c:if test="${not empty contactNumberError}">
							<p class="errorMessage">${contactNumberError}</p>
						</c:if>
					</div>
					<div class=columnGroup>
						<label for="email">Email</label> <input type="text" id="email"
							name="email" value="${email}" required>
						<c:if test="${not empty emailError}">
							<p class="errorMessage">${emailError}</p>
						</c:if>

					</div>
				</div>
				<div class=rowGroup>
					<div class=columnGroup>
						<label for="password">Password</label> <input type="password"
							id="pw" name="password" value="${password}" required>
						<c:if test="${not empty passwordError}">
							<p class="errorMessage">${passwordError}</p>
						</c:if>

					</div>
					<div class=columnGroup>
						<label for="confimPassword">Confirm Password</label> <input
							type="password" id="rePw" name="confirmPassword"
							value="${confirmPassword}" required>
						<c:if test="${not empty confirmPasswordError}">
							<p class="errorMessage">${confirmPasswordError}</p>
						</c:if>
					</div>
				</div>
				<div class="button">
					<button type="submit">Register</button>
				</div>
			</form>
		</div>
	</div>


</body>
</html>