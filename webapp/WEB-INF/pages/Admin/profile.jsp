<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<img src="${pageContext.request.contextPath}/resources/adminprofile.jpg">
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
			<p>Profile information</p>
			<div class="personalDetailsContainer">
				<div class="personalDetails">
					<h4>Username</h4>
					<input type="text" id="username" name="username" required>
				</div>
				<div class="personalDetails">
					<h4>First Name</h4>
					<input type="text" id="firstName" name="firstName" required>
				</div>
			</div>
			<div class="personalDetailsContainer">
				<div class="personalDetails">
					<h4>Last Name</h4>
					<input type="text" id="lastName" name="lastName" required>
				</div>
				<div class="personalDetails">
					<h4>Dob</h4>
					<input type="date" id="date" name="date" required>
				</div>
			</div>
			<p>Contact info</p>
			<div class="personalDetailsContainer">
				<div class="personalDetails">
					<h4>Contact Number</h4>
					<input type="text" id="cNumber" name="cNumber" required>
				</div>
				<div class="personalDetails">
					<h4>Email</h4>
					<input type="text" id="email" name="email" required>
				</div>
			</div>
			<button type="submit">Save changes</button>
		</div>
	</div>
</body>
</html>