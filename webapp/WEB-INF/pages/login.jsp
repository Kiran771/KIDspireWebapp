<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<div class= content>
		<h1>Login</h1>
		<div class="loginField">
			<label for="username">User Name</label>
			<input type="text" id="username" name="username" required>
			<label for="password">Password</label>
			<input type="text" id="password" name="password" required>
			<label for="forgot">Forgot password?</label>
			<button type="submit">Login</button>
		</div>
	</div>
</body>
</html>