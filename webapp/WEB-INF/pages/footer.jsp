<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css">
</head>
<body>
	<footer class=footer>
		<div class="footerContainer">
			<div class="footerContent">
				<h2>
					<span
						style='color: rgb(134, 184, 186); margin-bottom: .3rem; margin-right: 2.3rem'>KIDspire.</span>
				</h2>
				<p>Your Reliable Partner</p>
				<p>"Safe Care,happy kid"</p>
				<h3 class="followUsOn">Follow us on:</h3>
				<div class="icons">
					<i class="fa-brands fa-facebook"></i> <i
						class="fa-brands fa-instagram"></i> <i
						class="fa-brands fa-twitter"></i>

				</div>
			</div>
			<div class="footerContent">
				<h2 class="title">Quick links</h2>
				<ul class="quickLinks">
					<li><a
						href="{$pageContext.request.contextPath}/pages/home.jsp">Home</a></li>
					<li><a
						href="{$pageContext.request.contextPath}/pages/babysitter.jsp">Babysitter</a></li>
					<li><a
						href="{$pageContext.request.contextPath}/pages/blog.jsp">Blog</a></li>
					<li><a href="{$pageContext.request.contextPath}/pages/faq.jsp">FAQ</a></li>
					<li><a
						href="{$pageContext.request.contextPath}/pages/aboutUs.jsp">About
							us</a></li>
					<li><a
						href="{$pageContext.request.contextPath}/pages/contactUs.jsp">Contact
							us</a></li>
				</ul>
			</div>
			<div class="footerContent">
				<h2 class="title">Our services</h2>
				<ul class="serviceList">
					<li>✔ Babysitting</li>
					<li>✔ Infant Care</li>
					<li>✔ Part-Time Nanny</li>
					<li>✔ Overnight Care</li>
					<li>✔ Emergency Booking</li>
					<li>✔ Special Needs Support</li>
				</ul>
			</div>
			<div class="footerContent">
				<h2 class="newsLetter">News Letter Subscription</h2>
				<div class="subscribeBox">
					<input type="text" placeholder="Subscribe to our new letter" />
					<button>Subscribe</button>
				</div>

			</div>
		</div>
		<div class="footerBottom">
			<h2>@2025 KIDspire ALL right reserved</h2>
		</div>
	</footer>
</body>
</html>