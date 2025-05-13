<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<link rel="stylesheet"
	href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/header.css">
</head>
<body>
	<%@ page import="jakarta.servlet.http.HttpSession"%>
	<%@ page import="jakarta.servlet.http.HttpServletRequest"%>
	<section id="sidebar">
		<a href="#" class="logo">KIDspire<span>.</span></a>
		<ul class="side-menu top">
			<li class="active"><a
				href="${pageContext.request.contextPath}/adminDashboard"> <i
					class="fa-solid fa-house"></i> <span class="text">DashBoard</span>
			</a></li>
			<li><a
				href="${pageContext.request.contextPath}/babysitterMngController">
					<i class='bx bxs-baby-carriage'></i> <span class="text">Babysitter
						Management</span>
			</a></li>

			<li><a
				href="${pageContext.request.contextPath}/profileController"> <i
					class="fa-solid fa-user"></i> <span class="text">My profile</span>
			</a></li>
		</ul>
		<ul class="side-menu bottom">
			<li><a href="#"> <i class='bx bx-cog'></i> <span
					class="text">Settings</span>
			</a></li>
			<li>
				<form action="${pageContext.request.contextPath}/logoutController"
					method="post" style="display: inline;">
					<button type="submit" class="logout"
						style="background: none; border: none; color: inherit; cursor: pointer;">
						<i class="fa-solid fa-right-from-bracket"></i> <span class="text">Logout</span>
					</button>
				</form>
			</li>

		</ul>
	</section>
	<section id="content">
		<nav>
			<form action="#">
				<div class="form-input">
					<input type="search" placeholder="Search...">
					<button type="submit" class="search-btn">
						<i class="fa-solid fa-magnifying-glass"> </i>
					</button>
				</div>
			</form>
			<a href="#" class="notification"> <i class='bx bx-bell'></i> <span
				class="num">8</span>
			</a> <a href="#" class="profile"> <img
				src="${pageContext.request.contextPath }/resources/profile.jpg"
				onclick="toggleMenu()">
			</a>
			<div class="subMenuWrap" id="subMenu">
				<div class="subMenu">
					<div class=userInfo>
						<img
							src="${pageContext.request.contextPath}/resources/profile.jpg">
						<h2>Alice Sen</h2>
					</div>
					<hr style="border: 1px solid #ccc; margin: .5rem; width: 100%;">
					<a href="${pageContext.request.contextPath}/profileController"
						class="subMenuLink"> <span class="text"><i
							class="fa-solid fa-circle-user" style="color: #000000;"></i> Edit
							Profile</span>
					</a> <a class="subMenuLink"> <span class="text"><i
							class="fa-solid fa-gear" style="color: #000000;"></i> Setting &
							Privacy</span>

					</a> <a class="subMenuLink"> <span class="text"><i
							class="fa-brands fa-hire-a-helper" style="color: #000000;"></i>
							Help & Support</span>

					</a>
					<form action="${pageContext.request.contextPath}/logoutController"
						method="post" style="display: inline;">
						<button type="submit" class="subMenuLink"
							style="background: none; border: none; color: inherit; cursor: pointer;">
							<span class="text"> <i
								class="fa-solid fa-right-from-bracket" style="color: #000000;"></i>
								Logout
							</span>

						</button>
					</form>
				</div>
			</div>
		</nav>
	</section>
	<script src="${pageContext.request.contextPath }/js/adminDashboard.js"></script>
	<script src="${pageContext.request.contextPath }/js/subMenu.js"></script>


</body>
</html>