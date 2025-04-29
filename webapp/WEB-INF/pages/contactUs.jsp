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
href="${pageContext.request.contextPath}/css/contactUs.css">
</head>
<body>
	<jsp:include page="headerUser.jsp" />
	<div class="home">
		<h2>Contact us</h2>
		<div class="imgBanner">
			<img src="${pageContext.request.contextPath}/resources/contactUsImgB1.JPG">
		</div>
	</div>
	<div class="contactInfo">
		<h1>Contact Information</h1>
		<div class="info">
			<div class=contactRow>
				<i class="fa-solid fa-phone-volume" style="color: #000000;"></i>
				<p>+97798000000</p>
			</div>
			<div class="contactRow">
				<i class="fa-solid fa-envelope"></i>
				<p>kid@gamil.com</p>
			</div>
			<div class="contactRow">
				<i class="fa-regular fa-message"></i>
				<p>kid75</p>
			</div>
			
		</div>
	</div>
	<div class="getInTouchContainer">
		<div class="getInTouch">
			<h1>Get in touch</h1>
			<label for="email">Email:</label>
           	<input type="email" id="email" placeholder="Enter your email" required>
           	<label for="message">Message:</label>
            <textarea id="message" rows="5" placeholder="Your message here..." required></textarea>
            <button type="button" class="contact-btn">Send Message</button>
		</div>
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>