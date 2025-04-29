<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
href="${pageContext.request.contextPath }/css/adminDashboard.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<section id="content">
		<main>
			<h1>DashBoard</h1>	
			<div class="box-info">
				<div class="info">
					<i class='bx bx-registered icon-registered' ></i>
					<div class="data">
						<h3>30</h3>
						<h4>Registered Babysitter</h4>
					</div>
				</div>
				<div class="info">
					<i class='bx bxs-user-account icon-user'></i>
					<div class="data">
						<h3></h3>
						<h4>Active Babysitter</h4>
					</div>
				</div>
				<div class="info">
					<i class="fa-solid fa-user-check"></i>
					<div class="data">
						<h3></h3>
						<h4>Total Bookings</h4>
					</div>
				</div>
			</div>
			<div class="stats">
				<div class="picture">
				</div>
				<div class="picture">
				</div>
			</div>
		</main>
	</section>
	
	<script src="${pageContext.request.contextPath }/js/adminDashboard.js"></script>
	

</body>
</html>