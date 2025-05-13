<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/home.css ">
</head>
<body>
	<jsp:include page="headerUser.jsp" />
	<div class="imageContainer">
		<div class="tagline">
			<h1>Trusted Babysitters at Your Fingertips</h1>
			<p>Find and book the best babysitters near you in just a few
				clicks!</p>
			<button type="button" class="exploreBtn">Book Now</button>
		</div>

		<div class=image>
			<img src="${pageContext.request.contextPath}/resources/kidsImg.jpg">
		</div>

	</div>
	<div class="dataContainer">
		<div class="data">
			<h3>700+</h3>
			<p>Users</p>
		</div>
		<div class="data">
			<h3>300+</h3>
			<p>Bookings</p>
		</div>
		<div class="data">
			<h3>150+</h3>
			<p>Employes</p>
		</div>
	</div>
	<div class="serviceContainer">
		<h3>Our Services</h3>
		<div class="serviceSpace">
			<div class="services">
				<i class="fa-solid fa-book" style="color: #38571a;"></i>
				<h2>Booking made easy</h2>
				<p>Book a babysitter with just a few clicks — it's fast and
					hassle-free</p>

			</div>
			<div class="services">
				<i class="fa-solid fa-star" style="color: #FFD43B;"></i>
				<h2>Real Reviews</h2>
				<p>Read genuine feedback from other parents to make confident
					decisions</p>

			</div>
			<div class="services">
				<i class="fa-regular fa-circle-check" style="color: #38571a;"></i>
				<h2>Safe and Verified Sitters</h2>
				<p>All sitters are background-checked and verified for your
					peace of mind</p>

			</div>
		</div>

	</div>
	<div class="topBabysitterContainer">
		<h2>Top Babysitters</h2>
		<div class="sliderWrapper">
			<button class="sliderArrow leftArrow">
				<i class="fa-solid fa-chevron-left"></i>
			</button>
			<div class="scrollWrapper">
				<div class="babysitters">
					<div class="topBabysitters">
						<img src="${pageContext.request.contextPath}/resources/top1.JPG">
						<p>Name: Riya Shah</p>
						<p>Experience: 4yrs</p>
					</div>
					<div class="topBabysitters">
						<img src="${pageContext.request.contextPath}/resources/top2.JPG">
						<p>Name: Helen Park</p>
						<p>Experience: 3yrs</p>
					</div>
					<div class="topBabysitters">
						<img src="${pageContext.request.contextPath}/resources/top3.JPG">
						<p>Name: Alison Sen</p>
						<p>Experience: 1yr</p>
					</div>
					<div class="topBabysitters">
						<img src="${pageContext.request.contextPath}/resources/top4.JPG">
						<p>Name: Sarah Lee</p>
						<p>Experience: 2yrs</p>
					</div>
					<div class="topBabysitters">
						<img src="${pageContext.request.contextPath}/resources/top5.JPG">
						<p>Name: Emma Brown</p>
						<p>Experience: 5yrs</p>
					</div>
					<div class="topBabysitters">
						<img src="${pageContext.request.contextPath}/resources/top6.JPG">
						<p>Name: Miley Brown</p>
						<p>Experience: 4yrs</p>
					</div>
					<div class="topBabysitters">
						<img src="${pageContext.request.contextPath}/resources/top7.JPG">
						<p>Name: Julie Shah</p>
						<p>Experience: 3yrs</p>
					</div>
				</div>
			</div>
			<button class="sliderArrow rightArrow">
				<i class="fa-solid fa-chevron-right"></i>
			</button>
		</div>
	</div>
	<div class=getInTouchContainer>
		<div class="inputImageSpace">
			<div class="pictures">
				<img
					src="${pageContext.request.contextPath}/resources/contactUs1.jpg">

			</div>
			<div class="inputGroup">
				<h2>Get in touch</h2>
				<label for="email">Email:</label> <input type="email" id="email"
					placeholder="Enter your email" required> <label
					for="message">Message:</label>
				<textarea id="message" rows="5" placeholder="Your message here..."
					required></textarea>
				<button type="button" class="contact-btn">Send Message</button>
			</div>
		</div>

	</div>
	<jsp:include page="footer.jsp" />
	<script
		src="${pageContext.request.contextPath}/js/horizontalImgSlider.js"></script>

</body>
</html>