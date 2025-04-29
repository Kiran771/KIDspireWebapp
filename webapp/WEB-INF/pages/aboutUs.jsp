<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="stylesheet" type="text/css"
href="${pageContext.request.contextPath}/css/aboutUs.css">
</head>
<body>
	<jsp:include page="headerUser.jsp" />
	<div class="aboutUs">
		<h1>About us</h1>
		<div class="imageRow">
			<img src="${pageContext.request.contextPath}/resources/aboutImg1.JPG">
			<img src="${pageContext.request.contextPath}/resources/aboutImg3.JPG">
			<img src="${pageContext.request.contextPath}/resources/aboutImg2.jpg">
			<img src="${pageContext.request.contextPath}/resources/aboutImg4.JPG">
		</div>
	</div>
	<div class="companyStats">
		<div class="details">
			<h2>3</h2>
			<p>Countries</p>
		</div>
		<div class="details">
			<h2>140</h2>
			<p>STAFFS</p>
		</div>
		<div class="details">
			<h2>2</h2>
			<p>OFFICES</p>
		</div>
		<div class="details">
			<h2>300</h2>
			<p>HAPPY CLIENTS</p>
		</div>
		
	</div>
	<div class="welcome">
		<p>Welcome to KIDspire, your trusted partner in providing safe,<br> 
		reliable and professional babysitting services.</p>
		<button>Get Started</button>
	</div>
	<div class="aboutDirector">
		<img src="${pageContext.request.contextPath}/resources/directorImg.JPG">
		<div class="riyanaShah">
			<p>Riyana Shah,<br>
			The founder of KIDspire is passinate about creating safe,reliable and joyful childcare experiences.
			With the background in Early Childhood Education and a love for working with children Riyana Shah, 
			started KIDspire to help families find trustworthy babysitters with ease and confident.<br>
			As a parent, mentor, or childcare expert,Riyana understands the challenges 
			families face in finding trustworthy babysitters. That’s why KIDspire was founded to give families 
			peace of mind and kids a joyful, safe environment.
			</p>
		</div>
	</div>
	
	<div class="line">
		<h4>Mission and Values</h4>
	</div>
	<div class="ourValuesContainer">
		<div class="mission">
		 	 <h2>Our Mission</h2>
		 	 <h3>✔ To empower parents with peace of mind and inspire kids through quality care.</h3>
			 <h3>✔ We believe every child deserves a nurturing environment, and every parent deserves dependable support.</h3>
		</div>
		<div class="ourValues">
			<h2>At KIDspire, we value:</h2>
			<h3>✔ Trust and Safety: Your child’s safety is our top priority.</h3>
			<h3>✔ Professionalism: We connect you only with trained and dependable 
			babysitters.</h3>
			<h3>✔ Simplicity: Booking a babysitter has never been this easy.</h3>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>