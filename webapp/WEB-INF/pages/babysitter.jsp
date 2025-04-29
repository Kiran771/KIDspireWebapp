<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="stylesheet" type="text/css"
href="${pageContext.request.contextPath}/css/babysitter.css ">
</head>
<body>
	<jsp:include page="headerUser.jsp" />
	<div class="slideshow-container">
	  <div class="outer-wrapper">
	    <div class="adjustment">
	      <img class="imageslides" src="${pageContext.request.contextPath}/resources/image1.jpg">
	      <img class="imageslides" src="${pageContext.request.contextPath}/resources/image3.jpg">
	      <img class="imageslides" src="${pageContext.request.contextPath}/resources/image4.jpg">
	      <img class="imageslides" src="${pageContext.request.contextPath}/resources/image6.jpg">
	    </div>
	  </div>
	 </div>
	 <div class="aboutService">
	 	<h2>Why parents trust us</h2>
	 	<div class="whyTrustUs">
		 	<div class="reason">
		 		<p>✔ Background-verified Babysitters</p>
		 	</div>
		 	<div class="reason">
		 		<p>✔ 24/7 Customer Support</p>
		 	</div>
		 	<div class="reason">
		 		<p>✔ Affordable and Flexible Plans</p>
		 	</div>
	 	</div>
	 </div>

	 <div class="titleDesign">
		<h1>Choose your Babysitter</h1>
	 </div>
	 <div class="babysitters">
		 <div class="profileImg">
		 	<img src="${pageContext.request.contextPath}/resources/profile1.JPG">
		 	<h3>Name:Helen Park</h3>
		 	<h3>Experience:3yrs</h3>
		 	
		 </div>
		 <div class="profileImg">
		 	<img src="${pageContext.request.contextPath}/resources/profile2.JPG">
		 	<h3>Name:Ray Fang</h3>
		 	<h3>Experience:2yrs</h3>
		 </div>
		 <div class="profileImg">
		 	<img src="${pageContext.request.contextPath}/resources/profile3.JPG">
		 	<h3>Name:Riya Shah</h3>
		 	<h3>Experience:4yrs</h3>
		 </div>
		 <div class="profileImg">
		 	<img src="${pageContext.request.contextPath}/resources/profile4.jpg">
		 	<h3>Name:Nadine Sen</h3>
		 	<h3>Experience:4yrs</h3>
		 </div>
	 </div>
	  <div class="babysitters">
		 <div class="profileImg">
		 	<img src="${pageContext.request.contextPath}/resources/profile5.JPG">
		 	<h3>Name:Joy Kim</h3>
		 	<h3>Experience:3yrs</h3>
		 </div>
		 <div class="profileImg">
		 	<img src="${pageContext.request.contextPath}/resources/profile6.JPG">
		 	<h3>Name:Rujin Sun</h3>
		 	<h3>Experience:2yrs</h3>
		 </div>
		 <div class="profileImg">
		 	<img src="${pageContext.request.contextPath}/resources/profile7.JPG">
		 	<h3>Name:Karina Rai </h3>
		 	<h3>Experience:2yrs</h3>
		 </div>
		 <div class="profileImg">
		 	<img src="${pageContext.request.contextPath}/resources/profile8.JPG">
		 	<h3>Name:Alison Sen</h3>
		 	<h3>Experience:1yrs</h3>
		 </div>
	 </div>
	 <div class="offer">
	 	<h2>🎉 20% OFF In Your First Booking! 🎉</h2>
	 	<p>Book your first babysitter today and enjoy a special welcome discount.</p>
	 </div>
	 <jsp:include page="footer.jsp" />
	 
	<script src="${pageContext.request.contextPath }/js/babysitter.js"></script>
</body>
</html>