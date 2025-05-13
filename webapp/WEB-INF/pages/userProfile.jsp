<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/userProfile.css">

</head>
<body>
	<jsp:include page="headerUser.jsp" />
	<div class="profile-container">
		<div class="cover-image"></div>
		<div class="profile-info">
			<div class="profile-picture">
				<img src="${pageContext.request.contextPath}/resources/profile.jpg"
					alt="Profile Picture"
					style="width: 100%; height: 100%; border-radius: 50%;">
			</div>
			<div class="profile-details">
				<h1></h1>
			</div>
			<button class="view-profile-btn">View Profile</button>
		</div>

		<div class="details-container">

			<div class="change-section">
				<h2>Change Password</h2>

				<label for="current-password">Current Password</label> <input
					type="password" id="current-password" name="current-password"
					required> <label for="new-password">New Password</label> <input
					type="password" id="new-password" name="new-password" required>

				<label for="confirm-password">Confirm New Password</label> <input
					type="password" id="confirm-password" name="confirm-password"
					required>

				<button type="submit" class="save-btn">Save Changes</button>
			</div>

			<div class="change-section">

				<form action="${pageContext.request.contextPath}/userProfile"
					method="post">
					<h2>User Details</h2>
					<input type="hidden" name="username" value="${username}"> <label
						for="full-name">First Name</label> <input type="text"
						id="first-name" name="firstName"
						value="${firstName!=null?firstName:user.firstName }" required>
					<c:if test="${not empty errorFname}">
						<p class="errorMessage">${errorFname}</p>
					</c:if>
					<label for="full-name">Last Name</label> <input type="text"
						id="last-name" name="lastName"
						value="${lastName!=null?lastName:user.lastName}" required>
					<c:if test="${not empty errorLname}">
						<p class="errorMessage">${errorLname}</p>
					</c:if>
					<label for="email">Email</label> <input type="email" id="email"
						name="email" value="${email!=null? email:user.email }" required>
					<c:if test="${not empty errorEmail}">
						<p class="errorMessage">${errorEmail}</p>
					</c:if>

					<label for="phone">Phone Number</label> <input type="tel"
						id="phone" name="phone"
						value="${phone!=null?phone:user.contactNumber }" required>
					<c:if test="${not empty errorContact}">
						<p class="errorMessage">${errorContact}</p>
					</c:if>

					<button type="submit" class="save-btn">Save Changes</button>
				</form>

			</div>
		</div>
	</div>

</body>
</html>