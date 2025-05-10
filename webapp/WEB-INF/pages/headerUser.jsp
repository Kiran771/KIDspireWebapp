<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<link rel="stylesheet" type="text/css"
href="${pageContext.request.contextPath}/css/headerUser.css">
</head>
<body>
	<header class="header">
  	<h1>KIDspire<span style='color:pink'>.</span></h1>
  	<div class="search">
  	<form action="${pageContext.request.contextPath}/babysitterController" method="post">
		<input type="search" name="searchName"placeholder="Search..." value="${param.searchName}">
		<button type="submit" class="search-btn">
			<i class="fa-solid fa-magnifying-glass"></i>
		</button>
	 </form>
	 </div>
	  <ul>
	    <li><a href="${pageContext.request.contextPath}/homeController">Home</a></li>
	    <li><a href="${pageContext.request.contextPath}/babysitterController">Babysitter</a></li>
	    <li><a href="${pageContext.request.contextPath}/blogController">Blog</a></li>
	    <li><a href="${pageContext.request.contextPath}/aboutusController">About us</a></li>
	    <li><a href="${pageContext.request.contextPath}/contactUsController">Contact us</a></li>
	    <li><a href="${pageContext.request.contextPath}/faqController">FAQ</a></li>
	  </ul>
	  <div class="profile">
		<img src="${pageContext.request.contextPath}/resources/profile.jpg" onclick="toggleMenu()">
		
	</div>
	<div class="subMenuWrap" id="subMenu">
		<div class="subMenu">
			<div class=userInfo>
				<img src="${pageContext.request.contextPath}/resources/profile.jpg">
				<h2>Riya Shah</h2>
			</div>
			<hr style="border: 1px solid #ccc; margin: .5rem;width:100%;">
			<a href="${pageContext.request.contextPath}/userProfile" class="subMenuLink">
    			<span class="text"><i class="fa-solid fa-circle-user" style="color: #000000;"></i> Edit Profile</span>
			</a>
			<a class="subMenuLink">
				<span class="text"><i class="fa-solid fa-gear" style="color: #000000;"></i>  Setting & Privacy</span>
				
			</a>
			<a class="subMenuLink">
				<span class="text"><i class="fa-brands fa-hire-a-helper" style="color: #000000;"></i> Help & Support</span>
				
			</a>
			<form action="${pageContext.request.contextPath}/logoutController" method="post" style="display: inline;">
    			<button type="submit" class="subMenuLink" style="background:none; border:none; color:inherit; cursor:pointer;">
       				 <span class="text">
           				 <i class="fa-solid fa-right-from-bracket" style="color: #000000;"></i> Logout
       	 			</span>
       			 
   			  </button>
		  </form>
		</div>
	</div>
	</header>
	
	<script src="${pageContext.request.contextPath }/js/subMenu.js"></script>

</body>
</html>