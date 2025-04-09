<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<link rel="stylesheet" href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'>
<link rel="stylesheet" type="text/css"
href="${pageContext.request.contextPath }/css/adminDashboard.css">
</head>
<body>
	<section id="sidebar">
		<a href="#" class="logo">KIDspire<span>.</span></a>
		<ul class="side-menu top">
			<li class="active">
				<a href="#">
					<i class="fa-solid fa-house"></i>
					<span class="text">DashBoard</span>	
				</a>
			</li>
			<li>
				<a href="#">
					<i class="fa-regular fa-message"></i>
					<span class="text">Message</span>	
				</a>
			</li>		
		</ul>
		<ul class="side-menu">
			<li>
				<a href="#">
					<i class='bx bxs-bell' ></i>
					<span class="text">Settings</span>	
				</a>
			</li>
			<li>
				<a href="#" class="logout">
					<i class="fa-solid fa-right-from-bracket"></i>
					<span class="text">Logout</span>	
				</a>
			</li>	
			
		</ul>
	</section>
	
	
	<section id="content">
		<nav>
			<form action="#">
				<div class="form-input">
					<input type="search" placeholder="Search...">
					<button type="submit" class="search-btn">
						<i class="fa-solid fa-magnifying-glass">
					</i></button>
				</div>
			</form>
			<a href="#" class="notification">
				<i class='bx bx-bell'></i>
				<span class="num">8</span>
			</a>
			<a href="#" class="profile">
				<img src="${pageContext.request.contextPath }/resources/profile.jpg">
			</a>
		</nav>
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
		</main>
	</section>
	
	
	<script src="${pageContext.request.contextPath }/js/adminDashboard.js"></script>
	

</body>
</html>