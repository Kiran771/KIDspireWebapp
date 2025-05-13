<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<div class=content>
		<h1>Login</h1>
		<c:if test="${not empty errorMessage}">
			<p class="invalidError">${errorMessage}</p>
		</c:if>
		<form action="${pageContext.request.contextPath}/loginController"
			method="post">
			<div class="loginField">
				<label for="username">User Name</label> <input type="text"
					id="username" name="username" required> <label
					for="password">Password</label> <input type="password"
					id="password" name="password" required> <label for="forgot"
					class="password">Forgot password?</label>
				<button type="submit" class="login">Login</button>
				<h3>or login with</h3>
				<img
					src="${pageContext.request.contextPath}/resources/googleicon.JPG"
					class=google>
			</div>
		</form>
	</div>
</body>
</html>