<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/profile.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="myProfile">
		<div class="profileImage">
			<p>Account Management</p>
			<img
				src="${pageContext.request.contextPath}/resources/adminprofile.jpg">
			<div class=button>
				<button>Update profile</button>
			</div>
			<h4>Old password</h4>
			<input type="password" id="pw" name="password" required>
			<h4>New password</h4>
			<input type="password" id="pw" name="password" required>
			<button class="changepw">Change password</button>
		</div>
		<div class="profileInfo">
			<p class="heading">Profile information</p>
			<form action="${pageContext.request.contextPath}/profileController"
				method="post">

				<div class="personalDetailsContainer">
					<div class="personalDetails">
						<h4>Username</h4>
						<input type="text" id="username" name="username"
							value="${username}" readonly required>
					</div>
					<div class="personalDetails">
						<h4>First Name</h4>
						<input type="text" id="firstName" name="firstName"
							value="${firstName != null ? firstName : user.firstName}"
							required>
						<c:if test="${not empty errorFname}">
							<p class="errorMessage">${errorFname}</p>
						</c:if>
					</div>
				</div>

				<div class="personalDetailsContainer">
					<div class="personalDetails">
						<h4>Last Name</h4>
						<input type="text" id="lastName" name="lastName"
							value="${lastName!=null? lastName: user.lastName}" required>
						<c:if test="${not empty errorLname}">
							<p class="errorMessage">${errorLname}</p>
						</c:if>
					</div>

				</div>
				<p class="heading">Contact info</p>
				<div class="personalDetailsContainer">
					<div class="personalDetails">
						<h4>Contact Number</h4>
						<input type="text" id="cNumber" name="cNumber"
							value="${cNumber!= null ? cNumber:user.contactNumber}" required>
						<c:if test="${not empty errorContact}">
							<p class="errorMessage">${errorContact}</p>
						</c:if>
					</div>
					<div class="personalDetails">
						<h4>Email</h4>
						<input type="text" id="email" name="email"
							value="${email!=null? email: user.email}" required>
						<c:if test="${not empty errorEmail}">
							<p class="errorMessage">${errorEmail}</p>
						</c:if>
					</div>
				</div>
				<button type="submit">Save changes</button>
			</form>
		</div>
	</div>
</body>
</html>